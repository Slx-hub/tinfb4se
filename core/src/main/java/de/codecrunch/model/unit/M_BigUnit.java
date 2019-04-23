package de.codecrunch.model.unit;

import com.badlogic.gdx.graphics.g3d.ModelInstance;

public class M_BigUnit extends MA_Unit {

    public M_BigUnit(){
        super(2,600);
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
