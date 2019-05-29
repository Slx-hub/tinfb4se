package de.codecrunch.model.tower;

import com.badlogic.gdx.graphics.g3d.ModelInstance;

import de.codecrunch.Model3DFactory;

public class M_MediumTower extends MA_Tower {

	@Override
	public float getReloadTime() {
		return 3;
	}

	@Override
	public int getDamage() {
		return 100;
	}


	@Override
	public int getPrice() {
		return 100;
	}

	@Override
	public int getRange() {
		return 2;
	}
	
	@Override
	public ModelInstance getModel() {
		if (model == null)
			model = Model3DFactory.instantiate(Model3DFactory.loadModel("towers/mediumTower.g3db"));
		return model;
	}
}
