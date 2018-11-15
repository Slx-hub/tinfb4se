package de.codecrunch.view;

import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import de.codecrunch.TowerAttackGame;

public class V_Menu extends VA_Screen {

    public V_Menu(TowerAttackGame game) {
        super(game);
    }

    @Override
    public void show() {
        Table table = new Table();
        table.setFillParent(true);
        stage.addActor(table);

        TextButton newGame = new TextButton("New Game", skin);
        TextButton preferences = new TextButton("Settings", skin);
        TextButton exit = new TextButton("Exit", skin);

        table.add(newGame).fillX().uniformX();
        table.row().pad(10, 0, 10, 0);
        table.add(preferences).fillX().uniformX();
        table.row();
        table.add(exit).fillX().uniformX();
    }
}
