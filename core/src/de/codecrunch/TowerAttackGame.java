package de.codecrunch;

import com.badlogic.gdx.Game;

import de.codecrunch.controller.C_Game;
import de.codecrunch.controller.C_Settings;
import de.codecrunch.view.VA_Screen;
import de.codecrunch.view.V_Game;
import de.codecrunch.view.V_LevelSelect;
import de.codecrunch.view.V_Menu;
import de.codecrunch.view.V_Settings;

public class TowerAttackGame extends Game {

	private VA_Screen screen;
	private C_Game game;
	private V_Game gameScreen;
	private V_LevelSelect levelSelectScreen;
	private V_Menu menuScreen;
	private V_Settings settingsScreen;

	public final static int GAMEID = 0;
	public final static int LEVELSELECTID = 1;
	public final static int MENUID = 2;
	public final static int SETTINGSID = 3;

	public TowerAttackGame dmygame;

	@Override
	public void create() {
		screen = new V_Menu(this);
		this.setScreen(screen);
	}

	public void changeScreen(int screenid) {
		switch (screenid) {
			case GAMEID:
				if (gameScreen == null) gameScreen = new V_Game(this);
				this.setScreen(gameScreen);
				break;
			case LEVELSELECTID:
				if (levelSelectScreen == null) levelSelectScreen = new V_LevelSelect(this);
				this.setScreen(levelSelectScreen);
				break;
			case MENUID:
				if (menuScreen == null) menuScreen = new V_Menu(this);
				this.setScreen(menuScreen);
				break;
			case SETTINGSID:
				if (settingsScreen == null) settingsScreen = new V_Settings(this);
				this.setScreen(settingsScreen);
				break;
		}

	}







}

