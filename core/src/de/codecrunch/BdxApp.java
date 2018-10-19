package de.codecrunch;

import java.util.*;

import com.badlogic.gdx.*;

import com.nilunder.bdx.*;

public class BdxApp implements ApplicationListener {

	public int TICK_RATE = 60;

	@Override
	public void create(){
		Bdx.TICK_RATE = this.TICK_RATE;
		Bdx.init();

		Scene.instantiators = new HashMap<String, Instantiator>();
		Scene.instantiators.put("Scene", new de.codecrunch.inst.iScene());
		Scene.instantiators.put("__Profiler", null);

		Bdx.scenes.add(new Scene("Scene"));
		Bdx.firstScene = "Scene";
	}

	@Override
	public void dispose(){
		Bdx.dispose();
	}

	@Override
	public void render(){
		Bdx.main();
	}

	@Override
	public void resize(int width, int height){
		Bdx.resize(width, height);
	}

	@Override
	public void pause(){
	}

	@Override
	public void resume(){
	}
}
