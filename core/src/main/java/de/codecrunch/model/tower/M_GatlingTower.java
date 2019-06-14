package de.codecrunch.model.tower;

import com.badlogic.gdx.graphics.g3d.ModelInstance;

import de.codecrunch.Model3DFactory;

public class M_GatlingTower extends MA_Tower {

    public M_GatlingTower() {
        super(1, 100, 500, 2);
    }

    @Override
    public ModelInstance getModel() {
        if (model == null)
            model = Model3DFactory.instantiate(Model3DFactory.loadModel("towers/gatlingTower.g3db"));
        return model;
    }
}
