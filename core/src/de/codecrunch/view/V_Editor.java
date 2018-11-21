package de.codecrunch.view;

import de.codecrunch.TowerAttackGame;
import de.codecrunch.controller.C_Editor;

public class V_Editor extends VA_Screen {
    private C_Editor controller;

    public V_Editor(TowerAttackGame game) {
        super(game);
    }

    public void setController(C_Editor controller) {
        this.controller = controller;
    }
}
