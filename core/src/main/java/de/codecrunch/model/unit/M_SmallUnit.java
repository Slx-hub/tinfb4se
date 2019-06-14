package de.codecrunch.model.unit;

import com.badlogic.gdx.graphics.g3d.ModelInstance;
import de.codecrunch.Model3DFactory;

public class M_SmallUnit extends MA_Unit {

    private String modelAssetString = "units/smallUnit.g3db";

    public M_SmallUnit(){
        super(20,100, 1);
    }

    @Override
    public int getCost() {
        return 20;
    }

    @Override
    public ModelInstance getModel() {

        if (model == null)
            model = Model3DFactory.instantiate(Model3DFactory.loadModel(modelAssetString));
        return model;
    }
}
