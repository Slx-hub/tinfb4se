package de.codecrunch.model;

import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.scenes.scene2d.ui.Container;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import java.io.Serializable;

public class M_Tile extends Container<Image> implements Serializable {
    public final int x_pos, y_pos;

    private transient ME_TileState state;
    //for serialization
    private int tileStateOrdinal;
    private int tileRotation;
    private transient ModelInstance gameModel;
    private transient Image editorImage;

    public M_Tile(ME_TileState state, int x_pos, int y_pos, int rotation) {
        this.state = state;
        this.x_pos = x_pos;
        this.y_pos = y_pos;
        this.tileRotation = rotation;
    }

    public ModelInstance getGameModel() {
        return gameModel;
    }

    public void setGameModel(ModelInstance gameModel) {
        this.gameModel = gameModel;
    }

    public ME_TileState getTileState() {
        return state;
    }

    public void setTileState(ME_TileState state) {
        this.state = state;
    }

    public int getTileRotation() {
        return tileRotation;
    }

    public void setTileRotation(int tileRotation) {
        this.tileRotation = tileRotation;
    }

    public Image getEditorImage() {
        return editorImage;
    }

    public void updateEditorImage() {
        editorImage = state.getEditorImage();
        editorImage.setOrigin(editorImage.getWidth() / 2, editorImage.getHeight() / 2);
        editorImage.setRotation(tileRotation);
        this.setActor(editorImage);
        //editorImage.setPosition(x_pos * 100, (y_pos + 1.5f) * 100);
    }

    public String toString() {
        return "[" + x_pos + "," + y_pos + "]";
    }

    public void deflate() {
        tileStateOrdinal = state.ordinal();
    }

    public void inflate() {
        state = ME_TileState.values()[tileStateOrdinal];
    }
}

