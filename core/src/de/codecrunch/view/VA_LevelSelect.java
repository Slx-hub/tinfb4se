package de.codecrunch.view;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import de.codecrunch.TowerAttackGame;
import de.codecrunch.controller.C_LevelSelect;
import de.codecrunch.model.M_Map;

public abstract class VA_LevelSelect extends VA_Screen {

    C_LevelSelect controller = new C_LevelSelect();

    public VA_LevelSelect(TowerAttackGame game) {
        super(game);
        controller.setup(this);
    }

    public void addLevelButtons(Table table) {
        TextButton up = new TextButton("^", uiSkin);
        TextButton down = new TextButton("v", uiSkin);

        table.add(up).row();

        controller.getLevelButtons(uiSkin).forEach(level -> {
            table.add(level).fillX().uniformX();
            table.row();
            level.addListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {
                    controller.selected(level.getText().toString());
                }
            });
        });

        table.add(down).row();

        up.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                controller.move(C_LevelSelect.UP);
            }
        });

        down.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                controller.move(C_LevelSelect.DOWN);
            }
        });
    }

    public abstract void startMap(M_Map map);
}
