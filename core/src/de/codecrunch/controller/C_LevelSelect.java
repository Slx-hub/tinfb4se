package de.codecrunch.controller;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import java.util.List;
import java.util.stream.Collectors;

import de.codecrunch.model.M_LevelSelect;

public class C_LevelSelect {
    M_LevelSelect model = new M_LevelSelect();
    public static final int UP = -1;
    public static final int DOWN = 1;

    public void load() {
        //TODO needs to load all maps from whatever location
    }

    public void move(int direction) {
        if (direction == UP && model.canScrollUp() || direction == DOWN && model.canScrollDown()) {
            int index = model.getIndex() + direction;
            model.setIndex(index);

            model.setCanScrollUp(index != 0);
            model.setCanScrollDown(index + model.getDisplayCount() < model.getLevels().size());
        }
    }

    public List<TextButton> getLevelButtons(Skin skin) {
        List<TextButton> buttons = model.getLevels().subList(model.getIndex(), Math.min(model.getDisplayCount() + model.getIndex() + 1, model.getLevels().size())).stream().map(string -> new TextButton(string, skin)).collect(Collectors.toList());
        while (buttons.size() < model.getDisplayCount())
            buttons.add(new TextButton("", skin));
        return buttons;
    }

    public List<String> getLevels() {
        return model.getLevels().subList(model.getIndex(), Math.min(model.getDisplayCount() + model.getIndex() + 1, model.getLevels().size()));
    }
}
