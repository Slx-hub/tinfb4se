package de.codecrunch.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import de.codecrunch.Model3DFactory;

public enum ME_TileState {
	EMPTY {
		@Override
		protected Image getImage() {
			return new Image(new Texture("tiles/textures/empty.png"));
		}

		@Override
		protected ModelInstance getModel() {
			return Model3DFactory.instantiate(Model3DFactory.empty);
		}
	},
	START {
		@Override
		protected Image getImage() {
			return new Image(new Texture("tiles/textures/start.png"));
		}

		@Override
		protected ModelInstance getModel() {
			return Model3DFactory.instantiate(Model3DFactory.start);
		}
	},
	END {
		@Override
		protected Image getImage() {
			return new Image(new Texture("tiles/textures/end.png"));
		}

		@Override
		protected ModelInstance getModel() {
			return Model3DFactory.instantiate(Model3DFactory.end);
		}
	},
	OCCUPIED {
		@Override
		protected Image getImage() {
			return new Image(new Texture("tiles/textures/occupied.png"));
		}

		@Override
		protected ModelInstance getModel() {
			return Model3DFactory.instantiate(Model3DFactory.occupied);
		}
	},
	PATH_STRAIGHT {
		@Override
		protected Image getImage() {
			Image image = new Image(new Texture("tiles/textures/path_straight.png"));
			return image;
		}

		@Override
		protected ModelInstance getModel() {
			return Model3DFactory.instantiate(Model3DFactory.path_straight);
		}
	},
	PATH_LEFT {
		@Override
		protected Image getImage() {
			return new Image(new Texture("tiles/textures/path_left.png"));
		}

		@Override
		protected ModelInstance getModel() {
			ModelInstance instance = Model3DFactory.instantiate(Model3DFactory.path_corner);
			instance.transform.rotate(Vector3.Y, -90);
			return instance;
		}
	},
	PATH_RIGHT {
		@Override
		protected Image getImage() {
			return new Image(new Texture("tiles/textures/path_right.png"));
		}

		@Override
		protected ModelInstance getModel() {
			ModelInstance instance = Model3DFactory.instantiate(Model3DFactory.path_corner);
			return instance;
		}
	},
	PATH_CROSS {
		@Override
		protected Image getImage() {
			return new Image(new Texture("tiles/textures/path_cross.png"));
		}

		@Override
		protected ModelInstance getModel() {
			return Model3DFactory.instantiate(Model3DFactory.path_cross);
		}
	},
	PATH_SPLIT_RIGHT {
		@Override
		protected Image getImage() {
			return new Image(new Texture("tiles/textures/path_split_right.png"));
		}

		@Override
		protected ModelInstance getModel() {
			return Model3DFactory.instantiate(Model3DFactory.path_split_right);
		}
	},
	PATH_SPLIT_LEFT {
		@Override
		protected Image getImage() {
			return new Image(new Texture("tiles/textures/path_split_left.png"));
		}

		@Override
		protected ModelInstance getModel() {
			return Model3DFactory.instantiate(Model3DFactory.path_split_left);
		}
	};

	private final float tileDistance = 10f;

	public Image getEditorImage(int rotation) {
		Image editorImage = getImage();
		editorImage.setOrigin(editorImage.getWidth() / 2, editorImage.getHeight() / 2);
		editorImage.setRotation(rotation);
		return editorImage;
	}

	public ModelInstance getGameModel(int rotation, int x_pos, int y_pos) {
		ModelInstance gameModel = getModel();
		gameModel.transform.rotate(Vector3.Y, rotation);
		gameModel.transform.setTranslation(x_pos * tileDistance, 0, y_pos * tileDistance);
		return gameModel;
	}

	protected abstract Image getImage();

	protected abstract ModelInstance getModel();
}
