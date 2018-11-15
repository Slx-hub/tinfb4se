package de.codecrunch;

import com.badlogic.gdx.Game;

import java.awt.event.ActionEvent;

import de.codecrunch.controller.C_Game;
import de.codecrunch.view.VA_Screen;
import de.codecrunch.view.V_Menu;

public class TowerAttackGame extends Game {

	private String levelSelected;
	private VA_Screen screen;
	private C_Game game;

	@Override
	public void create () {
		screen = new V_Menu(this);
		this.setScreen(screen);
	}

	@Override
	public void render () {

	}
	
	@Override
	public void dispose () {
	}

	private void processButton(ActionEvent e){

	}

	private void startGame(){}
}
