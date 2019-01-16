package de.codecrunch.model;

import java.util.LinkedList;
import java.util.List;

import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;

public class M_MapBatch extends ModelBatch {
	private List<ModelInstance> tiles = new LinkedList<>();
	
	public void renderAll(Environment environment) {
		tiles.forEach(tile -> super.render(tile, environment));
	}
	
	@Override
	public void dispose() {
		super.dispose();
	}
	
	public void addTile(ModelInstance tile) {
		tiles.add(tile);
	}
}
