package de.codecrunch.model;

import java.util.ArrayList;
import java.util.List;

public class M_LevelSelect {
    private boolean canScrollUp = false;
    private boolean canScrollDown = false;
    private final int displayCount = 4;
    private int index = 0;
    private List<String> levels = new ArrayList<String>();

    public boolean canScrollUp() {
        return canScrollUp;
    }

    public boolean canScrollDown() {
        return canScrollDown;
    }

    public void setCanScrollUp(boolean canScrollUp) {
        this.canScrollUp = canScrollUp;
    }

    public void setCanScrollDown(boolean canScrollDown) {
        this.canScrollDown = canScrollDown;
    }

    public int getDisplayCount() {
        return displayCount;
    }

    public int getIndex() {
        return index;
    }

    public List<String> getLevels() {
        return levels;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setLevels(List<String> levels) {
        this.levels = levels;
    }
}
