package de.codecrunch.model;

import com.badlogic.gdx.Gdx;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class M_LevelSelect {
    private final int displayCount = 4;
    private int index = 0;
    private List<File> levels;

    public int getDisplayCount() {
        return displayCount;
    }

    public boolean changeIndex(int delta) {
        System.out.println("Moving from " + index + " to " + (index + delta));
        if (index + delta >= 0 && index + delta + displayCount <= levels.size()) {
            index += delta;
            return true;
        }
        return false;
    }

    public List<String> getLevels() {
        return levels.subList(index, Math.min(displayCount + index + 1, levels.size())).stream().map(level -> level.getName().substring(0, level.getName().length() - 4)).collect(Collectors.toList());
    }

    public void load() {
        File folder = Gdx.files.local("maps").file();
        levels = Arrays.asList(folder.listFiles());
    }

    public M_Map loadMap(String name) {
        final String fileName = name + ".map";
        File file = levels.stream().filter(level -> level.getName().equals(fileName)).findAny().orElse(null);
        if (file == null)
            return null;

        M_Map map = null;
        try {
            ObjectInputStream stream = new ObjectInputStream(new FileInputStream(file));
            map = (M_Map)stream.readObject();
            stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        map.inflate();
        return map;
    }
}
