package de.codecrunch.model.unit;

import com.badlogic.gdx.graphics.g3d.ModelInstance;

import de.codecrunch.Model3DFactory;

public class M_FastUnit extends MA_Unit {

    private String modelAssetString = "units/fastUnit.g3db";

    public M_FastUnit(){
        super(25,100, 3);
    }

    @Override
    public int getCost() {
        return 70;
    }

    @Override
    public ModelInstance getModel() {
        if (model == null)
            model = Model3DFactory.instantiate(Model3DFactory.loadModel(modelAssetString));
        return model;
    }
}
