package de.codecrunch;

import com.badlogic.gdx.Game;

import de.codecrunch.controller.C_Editor;
import de.codecrunch.controller.C_Game;
import de.codecrunch.model.M_Map;
import de.codecrunch.view.V_Editor;
import de.codecrunch.view.V_EditorLevelSelect;
import de.codecrunch.view.V_Game;
import de.codecrunch.view.V_LevelSelect;
import de.codecrunch.view.V_Menu;
import de.codecrunch.view.V_Settings;

public class TowerAttackGame extends Game {

    private C_Game game;
    private C_Editor editor;

    private V_Game gameScreen;
    private V_LevelSelect levelSelectScreen;
    private V_Menu menuScreen;
    private V_Settings settingsScreen;
    private V_Editor editorScreen;
    private V_EditorLevelSelect editorLevelSelectScreen;


    public final static int SCREENID_GAME = 0;
    public final static int SCREENID_LEVELSELECT = 1;
    public final static int SCREENID_MENU = 2;
    public final static int SCREENID_SETTINGS = 3;
    public final static int SCREENID_EDITORLVLSELECT = 4;
    public final static int SCREENID_EDITOR = 5;

    @Override
    public void create() {
        screen = new V_Menu(this);
        this.setScreen(screen);
    }

    public void changeScreen(int screenid) {
        switch (screenid) {
            case SCREENID_GAME:
                if (gameScreen == null) gameScreen = new V_Game(this);
                this.setScreen(gameScreen);
                break;
            case SCREENID_LEVELSELECT:
                if (levelSelectScreen == null) levelSelectScreen = new V_LevelSelect(this);
                this.setScreen(levelSelectScreen);
                break;
            case SCREENID_MENU:
                if (menuScreen == null) menuScreen = new V_Menu(this);
                this.setScreen(menuScreen);
                break;
            case SCREENID_SETTINGS:
                if (settingsScreen == null) settingsScreen = new V_Settings(this);
                this.setScreen(settingsScreen);
                break;
            case SCREENID_EDITOR:
                if (editorScreen == null) editorScreen = new V_Editor(this);
                this.setScreen(editorScreen);
                break;
            case SCREENID_EDITORLVLSELECT:
                if (editorLevelSelectScreen == null) editorLevelSelectScreen = new V_EditorLevelSelect(this);
                this.setScreen(editorLevelSelectScreen);
                break;
        }
    }

    public void startEditor(M_Map map) {
        editor = new C_Editor(map);
        changeScreen(SCREENID_EDITOR);
    }

    public void startGame(M_Map map) {
        //Loads 3d Models -> May be put in loading screen later.
        Model3DFactory.setup();

        changeScreen(SCREENID_GAME);
    }


}

