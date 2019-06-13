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
		
		@Override
		public ME_TileStateGroup getGroup() {
			return ME_TileStateGroup.EMPTY;
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
		
		@Override
		public ME_TileStateGroup getGroup() {
			return ME_TileStateGroup.PATH;
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
		
		@Override
		public ME_TileStateGroup getGroup() {
			return ME_TileStateGroup.PATH;
		}
	},
	OCCUPIED {
		@Override
		protected Image getImage() {
			return new Image(new Texture("tiles/textures/empty.png"));
		}

		@Override
		protected ModelInstance getModel() {
			return Model3DFactory.instantiate(Model3DFactory.empty);
		}
		
		@Override
		public ME_TileStateGroup getGroup() {
			return ME_TileStateGroup.OBSTACLE;
		}
	},
	PATH_STRAIGHT {
		@Override
		protected Image getImage() {
			return new Image(new Texture("tiles/textures/pathStraight.png"));
		}

		@Override
		protected ModelInstance getModel() {
			return Model3DFactory.instantiate(Model3DFactory.pathStraight);
		}
		
		@Override
		public ME_TileStateGroup getGroup() {
			return ME_TileStateGroup.PATH;
		}
	},
	PATH_LEFT {
		@Override
		protected Image getImage() {
			return new Image(new Texture("tiles/textures/path_left.png"));
		}

		@Override
		protected ModelInstance getModel() {
			ModelInstance instance = Model3DFactory.instantiate(Model3DFactory.pathCorner);
			instance.transform.rotate(Vector3.Y, -90);
			return instance;
		}
		
		@Override
		public ME_TileStateGroup getGroup() {
			return ME_TileStateGroup.PATH;
		}
	},
	PATH_RIGHT {
		@Override
		protected Image getImage() {
			return new Image(new Texture("tiles/textures/path_right.png"));
		}

		@Override
		protected ModelInstance getModel() {
			return Model3DFactory.instantiate(Model3DFactory.pathCorner);
		}
		
		@Override
		public ME_TileStateGroup getGroup() {
			return ME_TileStateGroup.PATH;
		}
	},
	PATH_CROSS {
		@Override
		protected Image getImage() {
			return new Image(new Texture("tiles/textures/pathCross.png"));
		}

		@Override
		protected ModelInstance getModel() {
			return Model3DFactory.instantiate(Model3DFactory.pathCross);
		}
		
		@Override
		public ME_TileStateGroup getGroup() {
			return ME_TileStateGroup.PATH;
		}
	},
	PATH_SPLIT_RIGHT {
		@Override
		protected Image getImage() {
			return new Image(new Texture("tiles/textures/pathSplitRight.png"));
		}

		@Override
		protected ModelInstance getModel() {
			return Model3DFactory.instantiate(Model3DFactory.pathSplitRight);
		}
		
		@Override
		public ME_TileStateGroup getGroup() {
			return ME_TileStateGroup.PATH;
		}
	},
	PATH_SPLIT_LEFT {
		@Override
		protected Image getImage() {
			return new Image(new Texture("tiles/textures/pathSplitLeft.png"));
		}

		@Override
		protected ModelInstance getModel() {
			return Model3DFactory.instantiate(Model3DFactory.pathSplitLeft);
		}
		
		@Override
		public ME_TileStateGroup getGroup() {
			return ME_TileStateGroup.PATH;
		}
	};

	public static final float TILE_DISTANCE = 10f;

	public Image getEditorImage(int rotation) {
		Image editorImage = getImage();
		editorImage.setOrigin(editorImage.getWidth() / 2, editorImage.getHeight() / 2);
		editorImage.setRotation(rotation);
		return editorImage;
	}

	public ModelInstance getGameModel(int rotation, int xPos, int yPos) {
		ModelInstance gameModel = getModel();
		gameModel.transform.rotate(Vector3.Y, rotation);
		gameModel.transform.setTranslation(xPos * TILE_DISTANCE, 0, yPos * TILE_DISTANCE);
		return gameModel;
	}

	protected abstract Image getImage();

	protected abstract ModelInstance getModel();
	
	public abstract ME_TileStateGroup getGroup();
	
	public enum ME_TileStateGroup {
		PATH,OBSTACLE,EMPTY;
	}
}
