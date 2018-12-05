package de.codecrunch.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import de.codecrunch.TowerAttackGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Tower Attack";
		config.height = 576;
		config.width = 1024;
		new LwjglApplication(new TowerAttackGame(), config);
	}
}
