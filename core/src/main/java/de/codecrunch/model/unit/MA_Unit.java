package de.codecrunch.model.unit;

import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.Vector3;

import java.util.Iterator;

import de.codecrunch.controller.C_Game;
import de.codecrunch.model.ME_TileState;
import de.codecrunch.model.M_Tile;
import de.codecrunch.model.unit.state.MA_UnitState;
import de.codecrunch.model.unit.state.M_UnitState_DONE;
import de.codecrunch.model.unit.state.M_UnitState_DRIVE_FORWARD;
import de.codecrunch.model.unit.state.M_UnitState_IDLE;
import de.codecrunch.model.unit.state.M_UnitState_ROTATE_LEFT;
import de.codecrunch.model.unit.state.M_UnitState_ROTATE_RIGHT;

public abstract class MA_Unit {

    private int speed;
    private int moneyPerTileReached;
    private int maxLife;
    private int currentLife;
    private Iterator<M_Tile> pathIterator;
    protected C_Game game;
    protected M_Tile currentTile;
    protected ModelInstance model;
    protected MA_UnitState state = new M_UnitState_IDLE();

    public MA_Unit(int speed, int maxLife, int moneyPerTile) {
        setSpeed(speed);
        setMaxLife(maxLife);
        setCurrentLife(maxLife);
        moneyPerTileReached = moneyPerTile;
    }

    public abstract ModelInstance getModel();

    public abstract int getCost();

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int speed) {
        if (speed >= 0) {
            this.speed = speed;
        }
    }

    public int getMaxLife() {
        return this.maxLife;
    }

    public void setMaxLife(int maxLife) {
        if (maxLife > 0) {
            this.maxLife = maxLife;
        }
    }

    public int getCurrentLife() {
        return currentLife;
    }

    public boolean isDead() {
        return currentLife <= 0;
    }

    public boolean isDone() {return state.isDone();}

    public void setCurrentLife(int currentLife) {
        if (this.maxLife < currentLife) {
            this.currentLife = maxLife;
        } else {
            this.currentLife = currentLife;
        }
    }

    public void takeDamage(int damage) {
        if (this.currentLife < damage) {
            die();
        } else {
            setCurrentLife(this.currentLife - damage);
        }
    }

    private void die() {
        setCurrentLife(0);
        currentTile.unitLeft(this);
    }

    public void heal(int healing) {
        if (currentLife == 0 || this instanceof M_HealUnit)
            return;

        System.out.println(this);

        if (this.maxLife < (this.currentLife + healing)) {
            setCurrentLife(this.maxLife);
        } else {
            setCurrentLife(this.currentLife + healing);
        }
    }

    public void setPath(Iterator<M_Tile> iterator) {
        this.pathIterator = iterator;
        currentTile = pathIterator.next();
        setInitialPosition();
    }

    public void setGame(C_Game game) {
        this.game = game;
    }

    public void tick(float delta) {
        move(delta);
    }

    public int getXTile() {
        return currentTile.xPos;
    }

    public int getYTile() {
        return currentTile.yPos;
    }

    public void move(float delta) {
        // Move unit
        boolean hasArrived = state.applyMovement(model.transform, speed * delta);

        if (hasArrived) {
            // if he's DONE rotating, drive to the next tile
            if (state.isRotating()) {
                state = new M_UnitState_DRIVE_FORWARD();
                return;
            }

            currentTile.unitLeft(this);

            if (!state.isIdle())
                currentTile = pathIterator.next();

            currentTile.unitEntered(this);

            if (!pathIterator.hasNext()) {
                state = new M_UnitState_DONE();
                return;
            }

            tileReached();

            switch (currentTile.getTileState()) {
                case PATH_LEFT:
                    state = new M_UnitState_ROTATE_LEFT();
                    break;
                case PATH_RIGHT:
                    state = new M_UnitState_ROTATE_RIGHT();
                    break;
                default:
                    state = new M_UnitState_DRIVE_FORWARD();
            }
        }
    }

    protected void tileReached() {
        game.yieldUnitMoney(moneyPerTileReached);
    }

    private void setInitialPosition() {
        model.transform.setTranslation(currentTile.xPos * ME_TileState.TILE_DISTANCE, 0f, currentTile.yPos * ME_TileState.TILE_DISTANCE);
        model.transform.rotate(Vector3.Y, currentTile.getTileRotation() - 90f);
    }
}
