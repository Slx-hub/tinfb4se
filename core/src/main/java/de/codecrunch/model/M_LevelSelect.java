package de.codecrunch.model;

import com.badlogic.gdx.Gdx;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class M_LevelSelect {
    private static final int displayCount = 4;
    private int index = 0;
    private List<File> levels = Collections.emptyList();

    public int getDisplayCount() {
        return displayCount;
    }

    public boolean changeIndex(int delta) {
        if (index + delta >= 0 && index + delta + displayCount <= levels.size()) {
            index += delta;
            return true;
        }
        return false;
    }

    public List<String> getLevels() {
        load();
        return levels.subList(index, Math.min(displayCount + index + 1, levels.size())).stream().map(level -> level.getName().substring(0, level.getName().length() - 4)).collect(Collectors.toList());
    }

    public void load() {
        File folder = Gdx.files.local("maps/").file();
        File[] files = folder.listFiles();
        if (files != null)
            levels = Arrays.asList(files);
    }

    public M_Map loadMap(String name) {
        final String fileName = name + ".map";
        File file = levels.stream().filter(level -> level.getName().equals(fileName)).findAny().orElse(null);
        if (file == null)
            return null;

        M_Map map = null;
        try {
            try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(file))) {
                map = (M_Map) stream.readObject();
            }
        } catch (Exception e) {
            Gdx.app.error("TowerAttack", e.getMessage(), e);
        }
        if (map != null) {
            map.inflate();
        }
        return map;
    }

    public void delete(String levelName) {
        String fileName = levelName + ".map";
        File file = levels.stream().filter(level -> level.getName().equals(fileName)).findAny().orElse(null);
        if (file != null)
            file.delete();
        load();
    }
}
