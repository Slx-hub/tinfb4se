package de.codecrunch.model.unit;

import com.badlogic.gdx.graphics.g3d.ModelInstance;

import de.codecrunch.Model3DFactory;

public class M_HealFountain extends MA_Unit {

    private int healRadius;
    private int healingPerSecond;
    private String modelAssetString = "units/unit.g3db";

    public M_HealFountain(){
        super(0,1000);
        this.healRadius = 2; // tiles
        this.healingPerSecond = 10;
    }

    @Override
    public int getCost() {
        return 0;
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
        if (model == null)
            model = Model3DFactory.instantiate(Model3DFactory.loadModel(modelAssetString));
        return model;

    }
}
