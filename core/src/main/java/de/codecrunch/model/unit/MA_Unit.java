package de.codecrunch.model.unit;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;

import java.util.Iterator;

import de.codecrunch.model.M_Tile;

public abstract class MA_Unit {
    private String direction = "o";
    private int speed;
    private int maxLife;
    private int currentLife;
    private int currentTile_xPos;
    private int currentTile_yPos;
    private Iterator<M_Tile> pathIterator;
    protected ModelInstance model;
    protected ME_UnitState state = ME_UnitState.DRIVE_FORWARD;

    public MA_Unit(int speed, int maxLife){
        setSpeed(speed);
        setMaxLife(maxLife);
        setCurrentLife(maxLife);
        setPos(0,0);
    }

    public abstract ModelInstance getModel();

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int speed) {
        if (!(speed < 0)){
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
        if(this.maxLife < currentLife){
            this.currentLife = maxLife;
        }else{
            this.currentLife = currentLife;
        }
    }

    public void takeDamage(int damage){
        if(this.currentLife < damage){
            setCurrentLife(0);
        }else{
            setCurrentLife(this.currentLife - damage);
        }
    }

    public void heal(int healing){
        if (currentLife==0){
            setCurrentLife(0);
        } else if (this.maxLife < (this.currentLife+healing)){
            setCurrentLife(this.maxLife);
        } else {
            setCurrentLife(this.currentLife + healing);
        }
    }

    public void setPos(int x_pos, int y_pos) {
        if (x_pos >= 0 && y_pos >= 0) {
            this.currentTile_xPos = x_pos;
            this.currentTile_yPos = y_pos;
        }
    }


    public int getCurrentTile_xPos() {
        return currentTile_xPos;
    }

    public int getCurrentTile_yPos() {
        return currentTile_yPos;
    }

    public void setPath(Iterator<M_Tile> iterator) {
        this.pathIterator = iterator;
    }

    public void tick(float delta) {
        move(delta);
        Vector3 tmp = new Vector3();
        model.transform.getTranslation(tmp);
        float x = tmp.x;
        float y = tmp.y;
        Gdx.app.log("model pos: ", "x = " + Float.toString(x) + "y = " + Float.toString(y));
    }
/*
        if (pathIterator.hasNext()) {
            M_Tile next = pathIterator.next();
            if (currentTile_yPos == next.y_pos) {
                if (currentTile_xPos < next.x_pos) { //Nach Norden
                    state = ME_UnitState.ROTATE_LEFT;
                    direction = "n";
                }
                if (currentTile_xPos > next.x_pos) { //Nach Süden

                }


            if (currentTile_xPos == next.x_pos) {
                if (currentTile_yPos < next.y_pos) { //Nach Westen
                }
                if (currentTile_yPos > next.y_pos) { //Nach Osten
                }
            }
            if (currentTile_yPos == 5) {
               state = ME_UnitState.ROTATE_LEFT;
            }

            //currentTile_xPos = next.x_pos;
            //currentTile_yPos = next.y_pos;
        }
        */
    //}

    public void move(float delta) {
        // Move unit
        boolean hasArrived = state.applyMovement(model.transform,speed * delta);


        // TODO If yes, change state
        // for example: state = ME_UnitState.RotateLeft
        if (hasArrived) {
            //next tile
            M_Tile next = pathIterator.next();
            if (currentTile_xPos < next.x_pos) {
                //state = ME_UnitState.ROTATE_LEFT;
            }
            if (currentTile_yPos < next.y_pos) {
                //state = ME_UnitState.ROTATE_LEFT;
            }
        }


        // End of Method.


        //Vector3 currentModel_Pos = new Vector3();
        //Vector3 n = new Vector3(70, 20,60);
        ////float f2 = -0.1F;

        //model.transform.getTranslation(currentModel_Pos);
        //currentModel_Pos.x = currentModel_Pos.x + Gdx.graphics.getDeltaTime();
        //currentModel_Pos.x = currentModel_Pos.x + f1;
        //currentModel_Pos.z = currentModel_Pos.z  + f2; //Westen
        //currentTile_xPos
        //if (currentTile_xPos >= currentModel_Pos.x)
         //   model.transform.setTranslation(currentModel_Pos);

        //model.transform.rotate(new Vector3(0, 1, 0), 0.5f);


/*        if (state == ME_UnitState.DRIVE_FORWARD){
            state.applyMovement(model.transform, speed * delta * 2);
        }
        else{
            state.applyMovement(model.transform, speed * delta * 295);
            state = ME_UnitState.DRIVE_FORWARD;
        }*/
/*        Vector3 start = new Vector3();
        model.transform.getTranslation(start);

        //Vector3 end = pathVectors.get(0);
        Vector3 end = path;

        float distance = start.dst(end);
        Vector3 direction = new Vector3(end);
        direction.sub(start).nor();

        model.transform.trn(direction.x * speed * delta, direction.y * speed * delta, direction.z * speed * delta);

        Vector3 currentPosition = new Vector3();
        model.transform.getTranslation(currentPosition);

        if(start.dst(currentPosition) >= distance){

            model.transform.setTranslation(end);

*//*            pathVectors.remove(0);
            if(pathVectors.isEmpty()){
                isMoving = false;
            }*//*

        }*/
    }

    float getModelRotation() {
        Quaternion quat = new Quaternion();
        model.transform.getRotation(quat);
        return quat.getAxisAngle(Vector3.Y);
    }
}
