package de.codecrunch;

import com.badlogic.gdx.Game;

import de.codecrunch.controller.C_Game;
import de.codecrunch.view.VA_Screen;
import de.codecrunch.view.V_Menu;

public class TowerAttackGame extends Game {

	private VA_Screen screen;
	private C_Game game;

	@Override
	public void create () {
		screen = new V_Menu(this);
		this.setScreen(screen);
	}
}
