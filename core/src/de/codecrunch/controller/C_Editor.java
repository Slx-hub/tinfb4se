package de.codecrunch.controller;

import com.badlogic.gdx.scenes.scene2d.Actor;

import de.codecrunch.model.M_Map;
import de.codecrunch.view.V_Editor;

public class C_Editor {

    private M_Map map;
    private V_Editor view;


    public C_Editor(M_Map m) {
        if (m != null)
            map = m;
        else {
            map = new M_Map();
        }

        map.foreachTile(tile -> tile.updateEditorImage());
    }

    public void setView(V_Editor view){
        this.view = view;
    }

    public M_Map getMap() {
        return map;
    }

    public void addToPath(Actor actor) {

    }
}
