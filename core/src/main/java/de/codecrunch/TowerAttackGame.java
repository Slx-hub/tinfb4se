package de.codecrunch;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;

import de.codecrunch.controller.C_Editor;
import de.codecrunch.controller.C_Game;
import de.codecrunch.model.M_Map;
import de.codecrunch.view.VA_Screen;
import de.codecrunch.view.V_Editor;
import de.codecrunch.view.V_EditorLevelSelect;
import de.codecrunch.view.V_Game;
import de.codecrunch.view.V_GameLevelSelect;
import de.codecrunch.view.V_Menu;
import de.codecrunch.view.V_Settings;

public class TowerAttackGame extends Game {

    private C_Game game;
    private C_Editor editor;

    private VA_Screen currentScreen;
    private V_Game gameScreen;
    private V_GameLevelSelect levelSelectScreen;
    private V_Menu menuScreen;
    private V_Settings settingsScreen;
    private V_Editor editorScreen;
    private V_EditorLevelSelect editorLevelSelectScreen;


    public final static int SCREENID_GAME = 0;
    public final static int SCREENID_GAMELVLSELECT = 1;
    public final static int SCREENID_MENU = 2;
    public final static int SCREENID_SETTINGS = 3;
    public final static int SCREENID_EDITORLVLSELECT = 4;
    public final static int SCREENID_EDITOR = 5;


    @Override
    public void create() {
        changeScreen(SCREENID_MENU);
    }

    /**
     * DON'T CHANGE SCREENS OVER ANY OTHER METHOD
     *
     * @param screenid ID of the screen you're switching to. see this classes final integers
     */
    public void changeScreen(int screenid) {
         modifyScreen(screenid, true);
    }

    private void setupScreen(int screenid) {
        modifyScreen(screenid, false);
    }

    private void modifyScreen(int screenid, boolean changeTo) {
        switch (screenid) {
            case SCREENID_GAME:
                if (gameScreen == null) gameScreen = new V_Game(this);
                currentScreen = gameScreen;
                break;
            case SCREENID_GAMELVLSELECT:
                if (levelSelectScreen == null) levelSelectScreen = new V_GameLevelSelect(this);
                currentScreen = levelSelectScreen;
                break;
            case SCREENID_MENU:
                if (menuScreen == null) menuScreen = new V_Menu(this);
                currentScreen = menuScreen;
                break;
            case SCREENID_SETTINGS:
                if (settingsScreen == null) settingsScreen = new V_Settings(this);
                currentScreen = settingsScreen;
                break;
            case SCREENID_EDITOR:
                if (editorScreen == null) editorScreen = new V_Editor(this);
                currentScreen = editorScreen;
                break;
            case SCREENID_EDITORLVLSELECT:
                if (editorLevelSelectScreen == null)
                    editorLevelSelectScreen = new V_EditorLevelSelect(this);
                currentScreen = editorLevelSelectScreen;
                break;
        }
        if (changeTo) {
            this.setScreen(currentScreen);
            Gdx.input.setInputProcessor(currentScreen.getStage());
        }
    }

    public void startEditor(M_Map map) {
        editor = new C_Editor(this, map);
        setupScreen(SCREENID_EDITOR);
        editor.setView(editorScreen);
        editorScreen.setController(editor);
        editorScreen.loadUI();
        changeScreen(SCREENID_EDITOR);
    }

    public void startGame(M_Map map, String levelName) {
        //Loads 3d Models -> May be put in loading screen later.
        Model3DFactory.setup();

        game = new C_Game(this, map);
        setupScreen(SCREENID_GAME);
        game.setView(gameScreen);
        gameScreen.setController(game);
        gameScreen.setLevelName(levelName);
        game.start();
        changeScreen(SCREENID_GAME);
        InputMultiplexer multiplexer = new InputMultiplexer();
        multiplexer.addProcessor(gameScreen.getStage());
        multiplexer.addProcessor(gameScreen.new GameInputProcessor());
        Gdx.input.setInputProcessor(multiplexer);
    }

}

