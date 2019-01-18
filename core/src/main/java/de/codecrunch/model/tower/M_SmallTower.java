package de.codecrunch.model.tower;

import com.badlogic.gdx.graphics.g3d.ModelInstance;

import de.codecrunch.Model3DFactory;

public class M_SmallTower extends MA_Tower {

	@Override
	public int getPrice() {
		return 50;
	}

	@Override
	public int getRange() {
		return 1;
	}

	@Override
	public ModelInstance getModel() {
		if (model == null)
			model = Model3DFactory.instantiate(Model3DFactory.loadModel("towers/stub.g3db"));
		return model;
	}
}
