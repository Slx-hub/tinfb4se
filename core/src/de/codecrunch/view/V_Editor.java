package de.codecrunch.view;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
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
        Table table = new Table();
        stage.addActor(table);
        table.setFillParent(true);
        table.debug();

        M_Tile[][] tiles = controller.getMap().getAllTiles();
        for (int y = 0; y < controller.getMap().y_count; y++) {
            for (int x = 0; x < controller.getMap().x_count; x++) {
                M_Tile m_tile = tiles[x][y];
                table.add(m_tile).center();
                m_tile.addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        controller.addToPath(m_tile);
                    }
                });
            }
            table.row();
        }

    }

}
