package de.codecrunch.model.unit;

import com.badlogic.gdx.graphics.g3d.ModelInstance;

import de.codecrunch.Model3DFactory;

public class M_BigUnit extends MA_Unit {

    private String modelAssetString = "units/bigUnit.g3db";

    public M_BigUnit(){
        super(10,600, 4);
    }

    @Override
    public int getCost() {
        return 100;
    }

    @Override
    public ModelInstance getModel() {

        if (model == null)
            model = Model3DFactory.instantiate(Model3DFactory.loadModel(modelAssetString));
        return model;
    }
}
