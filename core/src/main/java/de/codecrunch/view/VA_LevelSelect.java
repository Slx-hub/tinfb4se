package de.codecrunch.view;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
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

    public void addLevelButtons(Table table, boolean deleteable) {
        TextButton up = new TextButton("^", uiSkin);
        TextButton down = new TextButton("v", uiSkin);
        int rowcnt = 0;
        int width = 2 * (deleteable ? 2 : 1);

        table.add(up).colspan(width);
        table.row();

        for (TextButton level : controller.getLevelButtons(uiSkin)) {
            table.add(level).fillX().uniform();
            level.addListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {
                    controller.selected(level.getText().toString());
                }
            });

            if (deleteable) {
                TextButton del = new TextButton("X", uiSkin);
                table.add(del).width(60);
                del.addListener(new ChangeListener() {
                    @Override
                    public void changed(ChangeEvent event, Actor actor) {
                        Dialog dialog = new Dialog("Delete Level", VA_Screen.uiSkin) {
                            @Override
                            public void result(Object obj) {
                                if ((boolean) obj) {
                                    deleteLevel(level.getText().toString());
                                }
                            }
                        };
                        dialog.text("Really delete level: ");
                        dialog.getContentTable().row();
                        dialog.text(level.getText().toString() + "?");
                        dialog.getContentTable().row();
                        dialog.button("No", false);
                        dialog.button("Yes", true);
                        dialog.show(stage);
                    }
                });
            }
            rowcnt++;
            if (rowcnt == 2) {
                table.row();
            }
        }
        table.row();
        table.add(down).colspan(width);
        table.row();

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

    public void deleteLevel(String name) {
        controller.delete(name);
    }

    @Override
    public void show() {
        controller.updateButtons();
        super.render(0);
    }

    public abstract void startMap(M_Map map, String level);
}
