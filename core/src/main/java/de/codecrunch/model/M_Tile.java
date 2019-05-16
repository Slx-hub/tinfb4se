package de.codecrunch.model;

import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.scenes.scene2d.ui.Container;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import de.codecrunch.model.tower.MA_Tower;
import de.codecrunch.model.unit.MA_Unit;

public class M_Tile extends Container<Image> implements Serializable {
    public final int x_pos, y_pos;

    private transient ME_TileState state;
    //for serialization
    private int tileStateOrdinal;
    private int tileRotation;
    private transient ModelInstance gameModel;
    private transient Image editorImage;
    private transient Set<MA_Tower> towersInRange;

    public M_Tile(ME_TileState state, int x_pos, int y_pos, int rotation) {
        this.state = state;
        this.x_pos = x_pos;
        this.y_pos = y_pos;
        this.tileRotation = rotation;
    }

    public ModelInstance getGameModel() {
        return gameModel;
    }

    public ME_TileState getTileState() {
        return state;
    }

    public M_Tile setTileState(ME_TileState state) {
        this.state = state;
        return this;
    }

    public int getTileRotation() {
        return tileRotation;
    }

    public void setTileRotation(int tileRotation) {
        this.tileRotation = tileRotation;
    }

    public void updateEditorImage() {
        editorImage = state.getEditorImage(tileRotation);
        this.setActor(editorImage);
    }

    public void updateGameModel() {
        gameModel = state.getGameModel(tileRotation, x_pos, y_pos);
    }

    public String toString() {
        return "[" + x_pos + "," + y_pos + "]";
    }

    public void deflate() {
        tileStateOrdinal = state.ordinal();
    }

    public void inflate() {
        state = ME_TileState.values()[tileStateOrdinal];
        towersInRange = new HashSet<>();
    }

    public void registerTower(MA_Tower tower) {
        towersInRange.add(tower);
    }

    public void unitEntered(MA_Unit unit) {
        for (MA_Tower t : towersInRange)
            t.onUnitInRange(unit);
    }
}
