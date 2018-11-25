package de.codecrunch.model;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import java.io.Serializable;

public class M_Tile implements Serializable {
    public final ME_TileState state;
    public final int x_pos, y_pos;
    public final int rotation;

    private transient ModelInstance gameModel;
    private transient Image editorImage;

    public M_Tile(ME_TileState state, int x_pos, int y_pos, int rotation) {
        this.state = state;
        this.x_pos = x_pos;
        this.y_pos = y_pos;
        this.rotation = rotation;
    }

    public ModelInstance getGameModel() {
        return gameModel;
    }

    public void setGameModel(ModelInstance gameModel) {
        this.gameModel = gameModel;
    }

    public Image getEditorImage() {
        return editorImage;
    }

    public void updateEditorImage() {
        editorImage = state.getEditorImage();
        editorImage.setRotation(rotation);
        editorImage.setPosition(x_pos * 102, (y_pos + 1.5f) * 102);
    }
}

