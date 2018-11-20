package de.codecrunch.view;

import de.codecrunch.TowerAttackGame;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

public class V_Settings extends VA_Screen {

    private TowerAttackGame game;

    public V_Settings(TowerAttackGame game) {
        super(game);
        this.game = game;
    }

    @Override
    public void show() {
        Table table = new Table();
        table.setFillParent(true);
        stage.addActor(table);

        TextButton back = new TextButton("Back", skin);

        table.add(back).fillX().uniformX();


        back.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.changeScreen(towerAttackGame. MENUID);
            }
        });
    }
}
