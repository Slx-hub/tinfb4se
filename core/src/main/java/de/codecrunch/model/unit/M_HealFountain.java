package de.codecrunch.model.unit;

import com.badlogic.gdx.graphics.g3d.ModelInstance;

public class M_HealFountain extends MA_Unit {

    private int healRadius;
    private int healingPerSecond;

    public M_HealFountain(){
        super(0,1000);
        this.healRadius = 2; // tiles
        this.healingPerSecond = 10;
    }

    public int getHealRadius() {
        return healRadius;
    }

    public void setHealRadius(int healRadius) {
        if (!(healRadius<=0)){
            this.healRadius = healRadius;
        }
    }

    public int getHealingPerSecond() {
        return healingPerSecond;
    }

    public void setHealingPerSecond(int healingPerSecond) {
        if (!(healingPerSecond<=0)){
            this.healingPerSecond = healingPerSecond;
        }
    }

    public void healUnit(MA_Unit unit){
        unit.heal(healingPerSecond);
    }

    @Override
    public void setSpeed(int speed){
        super.setSpeed(0); // the healing fountain should not be able to move
    }

    @Override
    public void heal(int healing){
        super.heal(0);
    }

    @Override
    public ModelInstance getModel() {
        /*
        if (model == null)
            model = Model3DFactory.instantiate(Model3DFactory.loadModel("units/stub.g3db"));
        return model;
        */
        return null; // need model of a unit before uncommenting
    }
}
