package de.codecrunch.model;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;

public class M_RenderBatch extends ModelBatch {
	private List<ModelInstance> tiles = new LinkedList<>();
	
	public void renderAll(Environment environment) {
		tiles.forEach(new Consumer<ModelInstance>() {
			@Override
			public void accept(ModelInstance instance) {
				render(instance, environment);
			}
		});
	}
	
	@Override
	public void dispose() {
		super.dispose();
	}
	
	public void addElement(ModelInstance tile) {
		tiles.add(tile);
	}
}
