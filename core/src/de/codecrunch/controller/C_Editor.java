package de.codecrunch.controller;

import de.codecrunch.model.M_Map;
import de.codecrunch.view.V_Editor;

public class C_Editor {
    private M_Map map;
    private V_Editor view;


    public C_Editor(M_Map map) {
        if (map != null)
            this.map = map;
        else {
            map = new M_Map();
        }

        map.foreachTile(tile -> tile.setEditorSprite(tile.state.getEditorSprite(tile.rotation)));
    }

    public void setView(V_Editor view){
        this.view = view;
    }
}
