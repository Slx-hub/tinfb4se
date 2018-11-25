package de.codecrunch.view;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import de.codecrunch.TowerAttackGame;
import de.codecrunch.controller.C_Editor;
import de.codecrunch.model.M_Tile;

public class V_Editor extends VA_Screen {
    private C_Editor controller;

    public V_Editor(TowerAttackGame game) {
        super(game);
    }

    public void setController(C_Editor controller) {
        this.controller = controller;
    }

    @Override
    public void show() {
        for (M_Tile[] m_tiles : controller.getMap().getAllTiles()) {
            for (M_Tile m_tile : m_tiles) {
                stage.addActor(m_tile.getEditorImage());
                m_tile.getEditorImage().addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        controller.addToPath(event.getRelatedActor());
                    }
                });
            }
        }

    }

}
