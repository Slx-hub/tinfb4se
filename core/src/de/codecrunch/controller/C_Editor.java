package de.codecrunch.controller;

import com.badlogic.gdx.scenes.scene2d.Actor;

import de.codecrunch.model.ME_TileState;
import de.codecrunch.model.M_Map;
import de.codecrunch.model.M_Path;
import de.codecrunch.model.M_Tile;
import de.codecrunch.view.V_Editor;

public class C_Editor {

    private M_Map map;
    private V_Editor view;
    private M_Path<M_Tile> path = new M_Path<>();

    public C_Editor(M_Map m) {
        if (m != null)
            map = m;
        else {
            map = new M_Map();
        }

        map.foreachTile(M_Tile::updateEditorImage);
    }

    public void setView(V_Editor view) {
        this.view = view;
    }

    public M_Map getMap() {
        return map;
    }

    public void addToPath(M_Tile tile) {
        if (path.isEmpty()) {
            path.addFront(tile);
            tile.setTileState(ME_TileState.END);
            tile.updateEditorImage();
            return;
        }
        M_Tile head = path.head().get();
        M_Tile tail = path.tail().get();
        if (neighbour(head, tile)) {
            path.addFront(tile);
            update(path.head().getNext());
        }
        if (neighbour(tail, tile)) {
            path.addBack(tile);
            update(path.tail().getPrev());
        }
    }

    private boolean neighbour(M_Tile t1, M_Tile t2) {
        return Math.abs(t1.x_pos - t2.x_pos) <= 1 && t1.y_pos == t2.y_pos || Math.abs(t1.y_pos - t2.y_pos) <= 1 && t1.x_pos == t2.x_pos;
    }

    private void update(M_Path.Node node) {
        if (!node.hasNext() || !node.hasPrev())
            return;

    }
}
