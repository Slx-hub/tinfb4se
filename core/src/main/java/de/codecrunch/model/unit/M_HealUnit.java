package de.codecrunch.model.unit;

import com.badlogic.gdx.graphics.g3d.ModelInstance;

import de.codecrunch.Model3DFactory;

public class M_HealUnit extends MA_Unit {

    public M_HealUnit() {
        super(18, 200, 1);
    }

    private String modelAssetString = "units/healUnit.g3db";

    @Override
    public int getCost() {
        return 90;
    }

    @Override
    public ModelInstance getModel() {
        if (model == null)
            model = Model3DFactory.instantiate(Model3DFactory.loadModel(modelAssetString));
        return model;
    }

    @Override
    protected void tileReached() {
        super.tileReached();
        game.healUnitsInRange(currentTile, 1);
    }
}