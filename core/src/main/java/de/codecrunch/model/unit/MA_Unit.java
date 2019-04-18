package de.codecrunch.model.unit;

import java.util.Iterator;

import de.codecrunch.model.M_Tile;

public abstract class MA_Unit {
    private int speed;
    private int maxLife;
    private int currentLife;
    private int x_pos;
    private int y_pos;
    private Iterator<M_Tile> pathIterator;

    public MA_Unit(int speed, int maxLife){
        setSpeed(speed);
        setMaxLife(maxLife);
        setCurrentLife(maxLife);
        setPos(0,0);
    }

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
        this.x_pos = x_pos;
        this.y_pos = y_pos;
    }


    public int getX_pos() {
        return x_pos;
    }

    public int getY_pos() {
        return y_pos;
    }

    public void setPath(Iterator<M_Tile> iterator) {
        this.pathIterator = iterator;
    }

    public void move() {
        //TODO implement unit movement here
    }
}
