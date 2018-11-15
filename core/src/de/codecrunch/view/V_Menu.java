package de.codecrunch.view;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

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
        TextButton editor = new TextButton("Editor", skin);
        TextButton settings = new TextButton("Settings", skin);
        TextButton exit = new TextButton("Exit", skin);

        table.add(newGame).fillX().uniformX();
        table.row().pad(10, 0, 10, 0);
        table.add(editor).fillX().uniformX();
        table.row();
        table.add(settings).fillX().uniformX();
        table.row();
        table.add(exit).fillX().uniformX();

        editor.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                towerAttackGame.setScreen(new V_EditorLevelSelect(towerAttackGame));
            }
        });
    }
}
