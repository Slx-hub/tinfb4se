package de.codecrunch.controller;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import java.util.ArrayList;
import java.util.List;

import de.codecrunch.TowerAttackGame;
import de.codecrunch.model.M_LevelSelect;
import de.codecrunch.model.M_Map;
import de.codecrunch.view.VA_LevelSelect;

public class C_LevelSelect {
    private M_LevelSelect model = new M_LevelSelect();
    private VA_LevelSelect view;
    public static final int UP = -1;
    public static final int DOWN = 1;
    private List<TextButton> buttons;

    public void setup(VA_LevelSelect view) {
        this.view = view;
    }

    public void move(int delta) {
        if (model.changeIndex(delta))
            updateButtons();
    }

    public List<TextButton> getLevelButtons(Skin uiSkin) {
        model.load();
        if (buttons != null) {
            updateButtons();
            return buttons;
        }
        List<String> levels = model.getLevels();
        buttons = new ArrayList<>();
        for (int i = 0; i < model.getDisplayCount(); i++) {
            buttons.add(new TextButton(levels.size() > i ? levels.get(i) : "", uiSkin));
        }
        return buttons;
    }

    public void updateButtons() {
        List<String> levels = model.getLevels();
        for (int i = 0; i < buttons.size(); i++) {
            buttons.get(i).setText(levels.size() > i ? levels.get(i) : "");
        }
    }


    public void selected(String level) {
        M_Map loaded = model.loadMap(level);
        if (loaded != null)
            view.startMap(loaded, level);
    }
}
