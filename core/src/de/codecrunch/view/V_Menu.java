package de.codecrunch.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import de.codecrunch.TowerAttackGame;

public class V_Menu extends VA_Screen {
    private TowerAttackGame game;

    public V_Menu(TowerAttackGame game) {
        super(game);
        this.game = game;
    }

    @Override
    public void show() {
        Table table = new Table();
        stage.addActor(table);
        table.setFillParent(true);

        TextButton newGame = new TextButton("New Game", buttonSkin);
        TextButton editor = new TextButton("Editor", buttonSkin);
        TextButton settings = new TextButton("Settings", buttonSkin);
        TextButton exit = new TextButton("Exit", buttonSkin);

        table.defaults().pad(30,200,30,200).expand().fill();

        table.add(newGame).row();
        table.add(editor).row();
        table.add(settings).row();
        table.add(exit).row();

        editor.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.changeScreen(TowerAttackGame.SCREENID_EDITORLVLSELECT);
		    }
        });
		
        exit.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.exit();
            }
        });

        settings.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.changeScreen(TowerAttackGame.SCREENID_SETTINGS);
            }
        });

        newGame.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.changeScreen(TowerAttackGame.SCREENID_LEVELSELECT);
		    }
        });
    }
}
