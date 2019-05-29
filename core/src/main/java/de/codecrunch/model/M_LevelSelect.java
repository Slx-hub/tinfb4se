package de.codecrunch.model;

import com.badlogic.gdx.Gdx;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class M_LevelSelect {
    private final int displayCount = 4;
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
        return levels.subList(index, Math.min(displayCount + index + 1, levels.size())).stream().map(new Function<File, String>() {
            @Override
            public String apply(File level) {
                return level.getName().substring(0, level.getName().length() - 4);
            }
        }).collect(Collectors.toList());
    }

    public void load() {
        File folder = Gdx.files.local("maps").file();
        File[] files = folder.listFiles();
        if (files != null)
            levels = Arrays.asList(files);
    }

    public M_Map loadMap(String name) {
        final String fileName = name + ".map";
        File file = levels.stream().filter(new Predicate<File>() {
            @Override
            public boolean test(File level) {
                return level.getName().equals(fileName);
            }
        }).findAny().orElse(null);
        if (file == null)
            return null;

        M_Map map = null;
        try {
            ObjectInputStream stream = new ObjectInputStream(new FileInputStream(file));
            map = (M_Map) stream.readObject();
            stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(map!=null){
            map.inflate();
        }
        return map;
    }
}
