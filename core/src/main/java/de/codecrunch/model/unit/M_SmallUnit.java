package de.codecrunch.model.unit;

import com.badlogic.gdx.graphics.g3d.ModelInstance;
import de.codecrunch.Model3DFactory;

public class M_SmallUnit extends MA_Unit {

    public M_SmallUnit(){
        super(2,100);
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
