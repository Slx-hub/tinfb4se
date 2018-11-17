package de.codecrunch.view;

import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import de.codecrunch.TowerAttackGame;

public class V_LevelSelect extends VA_Screen {

    public V_LevelSelect(TowerAttackGame game) {
        super(game);
    }

    @Override
    public void show() {
        Table table = new Table();
        table.setFillParent(true);
        stage.addActor(table);

        TextButton back = new TextButton("Back", skin);

        table.add(back).fillX().uniformX();
    }
}
