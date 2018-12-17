package de.codecrunch;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import de.codecrunch.TowerAttackGame;

public class AndroidLauncher extends AndroidApplication {
	public TowerAttackGame towerAttackGame;

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		towerAttackGame = new TowerAttackGame();
		initialize(towerAttackGame, config);
	}
}
