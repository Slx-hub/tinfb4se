package de.codecrunch.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g3d.ModelInstance;

import de.codecrunch.Model3DFactory;

public enum ME_TileState {
    EMPTY {
        @Override
        public Sprite getEditorSprite(int rotation) {
            Sprite sprite = new Sprite(new Texture("tiles/textures/empty.png"));
            sprite.setRotation(rotation);
            return sprite;
        }

        @Override
        public ModelInstance getGameModel(int rotation) {
            return Model3DFactory.instantiate(Model3DFactory.empty, rotation);
        }
    }
    //TODO: implement all enum types
    //,OCCUPIED,PATH_STRAIGHT,PATH_LEFT,PATH_RIGHT,PATH_CROSS,PATH_SPLIT_RIGHT,PATH_SPLIT_LEFT
    ;

    public abstract Sprite getEditorSprite(int rotation);

    public abstract ModelInstance getGameModel(int rotation);
}
