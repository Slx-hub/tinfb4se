package de.codecrunch;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.event.ActionEvent;

import de.codecrunch.controller.C_Game;
import de.codecrunch.view.screen.VA_Screen;

public class TowerAttackGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	private String levelSelected;
	private VA_Screen screen = new VA_Screen() {
	};
	private C_Game game = new C_Game();

	private void processButton(ActionEvent e){

	}

	private void startGame(){}



	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("Logo.png");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}