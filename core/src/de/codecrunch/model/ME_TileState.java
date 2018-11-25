package de.codecrunch.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
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
    }
    //TODO: implement all enum types
    //,OCCUPIED,PATH_STRAIGHT,PATH_LEFT,PATH_RIGHT,PATH_CROSS,PATH_SPLIT_RIGHT,PATH_SPLIT_LEFT
    ;

    public abstract Image getEditorImage();

    public abstract ModelInstance getGameModel();
}
