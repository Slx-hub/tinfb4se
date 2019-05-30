package de.codecrunch.model;

import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;

import java.util.LinkedList;
import java.util.List;

public class M_RenderBatch extends ModelBatch {
	private List<ModelInstance> elements = new LinkedList<>();
	
	public void renderAll(Environment environment) {
		elements.forEach(instance -> render(instance, environment));
	}
	
	public void addElement(ModelInstance element) {
		elements.add(element);
	}

	public void removeElement(ModelInstance element) {
		elements.remove(element);
	}
}
