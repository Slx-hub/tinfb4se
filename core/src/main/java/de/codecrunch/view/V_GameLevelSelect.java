package de.codecrunch.view;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import de.codecrunch.TowerAttackGame;
import de.codecrunch.model.M_Map;

public class V_GameLevelSelect extends VA_LevelSelect {

    public V_GameLevelSelect(TowerAttackGame game) {
        super(game);
        Table table = new Table();
        table.setFillParent(true);
        stage.addActor(table);

        TextButton back = new TextButton("Back", uiSkin);

        addLevelButtons(table);
        table.add(back).colspan(2);

        back.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                towerAttackGame.changeScreen(TowerAttackGame.SCREENID_MENU);
            }
        });
    }


    public void startMap(M_Map map, String levelName) {
        towerAttackGame.startGame(map, levelName);
    }
}
