package de.codecrunch.model.tower;

import com.badlogic.gdx.graphics.g3d.ModelInstance;

import de.codecrunch.Model3DFactory;

public class M_BigTower extends MA_Tower {

    public M_BigTower() {
        super(5, 250, 200, 3);
    }

    @Override
    public ModelInstance getModel() {
        if (model == null)
            model = Model3DFactory.instantiate(Model3DFactory.loadModel("towers/bigTower.g3db"));
        return model;
    }
}
