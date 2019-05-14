package de.codecrunch.model.unit;

import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.Vector3;

import java.util.Iterator;

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
    private int maxLife;
    private int currentLife;
    private M_Tile currentTile;
    private Iterator<M_Tile> pathIterator;
    protected ModelInstance model;
    protected MA_UnitState state = new M_UnitState_IDLE();

    public MA_Unit(int speed, int maxLife) {
        setSpeed(speed);
        setMaxLife(maxLife);
        setCurrentLife(maxLife);
    }

    public abstract ModelInstance getModel();

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int speed) {
        if (!(speed < 0)) {
            this.speed = speed;
        }
    }

    public int getMaxLife() {
        return this.maxLife;
    }

    public void setMaxLife(int maxLife) {
        if (!(maxLife <= 0)) {
            this.maxLife = maxLife;
        }
    }

    public int getCurrentLife() {
        return currentLife;
    }

    public void setCurrentLife(int currentLife) {
        if (this.maxLife < currentLife) {
            this.currentLife = maxLife;
        } else {
            this.currentLife = currentLife;
        }
    }

    public void takeDamage(int damage) {
        if (this.currentLife < damage) {
            setCurrentLife(0);
        } else {
            setCurrentLife(this.currentLife - damage);
        }
    }

    public void heal(int healing) {
        if (currentLife == 0) {
            setCurrentLife(0);
        } else if (this.maxLife < (this.currentLife + healing)) {
            setCurrentLife(this.maxLife);
        } else {
            setCurrentLife(this.currentLife + healing);
        }
    }

    public void setPath(Iterator<M_Tile> iterator) {
        this.pathIterator = iterator;
    }

    public void tick(float delta) {
        move(delta);
    }

    public void move(float delta) {
        // Move unit
        boolean hasArrived = state.applyMovement(model.transform, speed * delta);

        if (hasArrived) {
            // if he's done rotating, drive to the next tile
            if (state.isRotating()) {
                state = new M_UnitState_DRIVE_FORWARD();
                //setUnitToTileRotation();
                return;
            }
            //next tile
            currentTile = pathIterator.next();

            if (!pathIterator.hasNext()) {
                state = new M_UnitState_DONE();
                return;
            }

            if (state.isIdle()) {
                setInitialPosition();
            }

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

    private void setInitialPosition() {
        model.transform.setTranslation(currentTile.x_pos * ME_TileState.tileDistance, 0f, currentTile.y_pos * ME_TileState.tileDistance);
        model.transform.rotate(Vector3.Y, currentTile.getTileRotation() - 90);
    }
}
