package de.codecrunch.model.unit;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import de.codecrunch.model.ME_TileState;
import de.codecrunch.model.M_RenderBatch;
import de.codecrunch.model.M_Tile;

public abstract class MA_Unit {
    Vector2 velocity = new Vector2();
    private int waypoint = 0, tolerance = 3;
    private List<M_Tile> tileList;
    private Vector3 directionVector;
    private M_Tile target;
    private int speed;
    private int maxLife;
    private int currentLife;
    private float x_pos;
    private float y_pos;
    private Iterator<M_Tile> pathIterator;
    protected ModelInstance model;
    protected ME_UnitState state = ME_UnitState.IDLE;

    public MA_Unit(int speed, int maxLife) {
        setSpeed(speed);
        setMaxLife(maxLife);
        setCurrentLife(maxLife);
        setPos(0, 0);
        tileList = new ArrayList<>();
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

    public void setPos(float x_pos, float y_pos) {
        this.x_pos = x_pos;
        this.y_pos = y_pos;
    }


    public float getX_pos() {
        return x_pos;
    }

    public float getY_pos() {
        return y_pos;
    }

    public void setPath(Iterator<M_Tile> iterator) {
        this.pathIterator = iterator;
    }

    public void tick(float delta) {
        move(delta);
    }

    public void move(float delta) {
        //test to rotate unit


        if(waypoint == 0){
            setPos(tileList.get(waypoint).x_pos * ME_TileState.tileDistance, tileList.get(waypoint).y_pos * ME_TileState.tileDistance);
            waypoint++;
        }
        if (isWaypointReached()) {
            setPos(tileList.get(waypoint).x_pos* ME_TileState.tileDistance, tileList.get(waypoint).y_pos* ME_TileState.tileDistance);
            System.out.println(waypoint+":"+ velocity);
            if (waypoint + 1 >= tileList.size()) {
                waypoint = 0;
            }
            else
                waypoint++;
        }
        float angle = (float) Math.atan2((tileList.get(waypoint).x_pos* ME_TileState.tileDistance) - x_pos, (tileList.get(waypoint).y_pos* ME_TileState.tileDistance )- y_pos);
        System.out.println("angle: " + angle);
        velocity.set((float) Math.cos(angle) * speed, (float) Math.sin(angle) * speed);
        this.setPos(x_pos + velocity.y*delta , y_pos +velocity.x*delta);
        this.getModel().transform.setFromEulerAngles(angle* MathUtils.radiansToDegrees+180,0,0);
        this.getModel().transform.setTranslation(x_pos , 0, y_pos );

    }


    public boolean isWaypointReached() {
        float absVal1,absVal2,absVal3,absVal4;
        absVal1 = Math.abs(tileList.get(waypoint).x_pos* ME_TileState.tileDistance - x_pos);
        absVal2 = Math.abs(speed / tolerance * Gdx.graphics.getDeltaTime());
        absVal3 = Math.abs(tileList.get(waypoint).y_pos* ME_TileState.tileDistance - y_pos);
        absVal4 = Math.abs(speed / tolerance * Gdx.graphics.getDeltaTime());
        return absVal1 <= absVal2 && absVal3 <= absVal4;
    }

    public void setTileList(List tiles){
        this.tileList = tiles;
    }
}
