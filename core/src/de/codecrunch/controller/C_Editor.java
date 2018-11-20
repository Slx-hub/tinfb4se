package de.codecrunch.controller;

import de.codecrunch.model.M_Map;

public class C_Editor {
    private M_Map map;

    public C_Editor(M_Map map) {
        if (map != null)
            this.map = map;
        else {
            map = new M_Map();
        }

        map.foreachTile(tile -> tile.setEditorSprite(tile.state.getEditorSprite(tile.rotation)));
    }
}
