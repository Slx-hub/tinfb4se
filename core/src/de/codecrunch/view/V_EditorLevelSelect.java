package de.codecrunch.view;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import java.util.List;

import de.codecrunch.TowerAttackGame;
import de.codecrunch.controller.C_LevelSelect;

public class V_EditorLevelSelect extends VA_Screen {
    C_LevelSelect selectController = new C_LevelSelect();

    public V_EditorLevelSelect(TowerAttackGame game) {
        super(game);
    }

    @Override
    public void show() {
        Table table = new Table();
        table.setFillParent(true);
        stage.addActor(table);
        selectController.load();

        TextButton newLevel = new TextButton("New Level", buttonSkin);
        TextButton up = new TextButton("^", buttonSkin);
        List<TextButton> levels = selectController.getLevelButtons(buttonSkin);
        TextButton down = new TextButton("v", buttonSkin);
        TextButton back = new TextButton("Back", buttonSkin);

        table.add(newLevel).fillX().uniformX();
        table.add(up).fillX().uniformX();
        table.row().pad(10, 0, 10, 0);
        levels.forEach(level -> {
            table.add(level).fillX().uniformX();
            table.row();
        });
        table.add(back);
        table.add(down);

        newLevel.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                towerAttackGame.startEditor(null);
            }
        });

        back.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                towerAttackGame.changeScreen(TowerAttackGame.SCREENID_MENU);
            }
        });
    }
}
