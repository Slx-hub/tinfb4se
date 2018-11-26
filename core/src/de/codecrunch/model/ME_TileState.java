package de.codecrunch.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import de.codecrunch.Model3DFactory;

public enum ME_TileState {
    EMPTY {
        @Override
        public Image getEditorImage() {
            Image image = new Image(new Texture("tiles/textures/empty.png"));
            return image;
        }

        @Override
        public ModelInstance getGameModel() {
            return Model3DFactory.instantiate(Model3DFactory.empty);
        }
    },
    END {
        @Override
        public Image getEditorImage() {
            Image image = new Image(new Texture("tiles/textures/end.png"));
            return image;
        }

        @Override
        public ModelInstance getGameModel() {
            return Model3DFactory.instantiate(Model3DFactory.end);
        }
    },
    OCCUPIED {
        @Override
        public Image getEditorImage() {
            Image image = new Image(new Texture("tiles/textures/occupied.png"));
            return image;
        }

        @Override
        public ModelInstance getGameModel() {
            return Model3DFactory.instantiate(Model3DFactory.occupied);
        }
    },
    PATH_STRAIGHT {
        @Override
        public Image getEditorImage() {
            Image image = new Image(new Texture("tiles/textures/path_straight.png"));
            return image;
        }

        @Override
        public ModelInstance getGameModel() {
            return Model3DFactory.instantiate(Model3DFactory.path_straight);
        }
    },
    PATH_LEFT {
        @Override
        public Image getEditorImage() {
            Image image = new Image(new Texture("tiles/textures/path_left.png"));
            return image;
        }

        @Override
        public ModelInstance getGameModel() {
            return Model3DFactory.instantiate(Model3DFactory.path_left);
        }
    },
    PATH_RIGHT {
        @Override
        public Image getEditorImage() {
            Image image = new Image(new Texture("tiles/textures/path_right.png"));
            return image;
        }

        @Override
        public ModelInstance getGameModel() {
            return Model3DFactory.instantiate(Model3DFactory.path_right);
        }
    },
    PATH_CROSS {
        @Override
        public Image getEditorImage() {
            Image image = new Image(new Texture("tiles/textures/path_cross.png"));
            return image;
        }

        @Override
        public ModelInstance getGameModel() {
            return Model3DFactory.instantiate(Model3DFactory.path_cross);
        }
    },
    PATH_SPLIT_RIGHT {
        @Override
        public Image getEditorImage() {
            Image image = new Image(new Texture("tiles/textures/path_split_right.png"));
            return image;
        }

        @Override
        public ModelInstance getGameModel() {
            return Model3DFactory.instantiate(Model3DFactory.path_split_right);
        }
    },
    PATH_SPLIT_LEFT {
        @Override
        public Image getEditorImage() {
            Image image = new Image(new Texture("tiles/textures/path_split_left.png"));
            return image;
        }

        @Override
        public ModelInstance getGameModel() {
            return Model3DFactory.instantiate(Model3DFactory.path_split_left);
        }
    },
    ;

    public abstract Image getEditorImage();

    public abstract ModelInstance getGameModel();
}
