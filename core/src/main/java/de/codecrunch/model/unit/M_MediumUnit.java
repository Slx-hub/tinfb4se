package de.codecrunch.model.unit;

import com.badlogic.gdx.graphics.g3d.ModelInstance;

import de.codecrunch.Model3DFactory;

public class M_MediumUnit extends MA_Unit {

    private String modelAssetString = "units/mediumUnit.g3db";

    public M_MediumUnit(){
        super(15,300);
    }

    @Override
    public int getCost() {
        return 50;
    }

    @Override
    public ModelInstance getModel() {
        if (model == null)
            model = Model3DFactory.instantiate(Model3DFactory.loadModel(modelAssetString));
        return model;
    }
}
