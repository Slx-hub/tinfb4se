package de.codecrunch.view;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import de.codecrunch.TowerAttackGame;
import de.codecrunch.model.M_Map;

public class V_EditorLevelSelect extends VA_LevelSelect {


    public V_EditorLevelSelect(TowerAttackGame game) {
        super(game);
        Table table = new Table();
        table.setFillParent(true);
        stage.addActor(table);

        TextButton newLevel = new TextButton("New Level", uiSkin);
        TextButton back = new TextButton("Back", uiSkin);

        table.add(newLevel).colspan(2).row();
        addLevelButtons(table);
        table.add(back).colspan(2);

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

    @Override
    public void startMap(M_Map map, String level) {
        towerAttackGame.startEditor(map);
    }
}
