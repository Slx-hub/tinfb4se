package de.codecrunch.controller;

import java.util.function.Consumer;

import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

import de.codecrunch.TowerAttackGame;
import de.codecrunch.model.ME_TileState;
import de.codecrunch.model.M_Game;
import de.codecrunch.model.M_Map;
import de.codecrunch.model.M_RenderBatch;
import de.codecrunch.model.M_Tile;
import de.codecrunch.model.tower.MA_Tower;
import de.codecrunch.model.unit.MA_Unit;
import de.codecrunch.view.V_Game;

public class C_Game {
	private M_Game model = new M_Game();
	private C_Computer computer = new C_Computer(this);
	private V_Game view;
	private TowerAttackGame towerAttackGame;
	private M_Map map;

	public C_Game(TowerAttackGame game, M_Map map) {
		towerAttackGame = game;
		this.map = map;
	}

	public void setView(V_Game view) {
		this.view = view;
	}

	public void start() {
		M_RenderBatch mapBatch = view.getMapBatch();
		map.foreachTile(new Consumer<M_Tile>() {
			@Override
			public void accept(M_Tile t) {
				t.updateGameModel();
				mapBatch.addElement(t.getGameModel());
			}
		});

		Timer.instance().scheduleTask(new Task() {
			private int timerCount = 0;

			@Override
			public void run() {
				computer.addMoney(50);
				computer.tick(timerCount);
				timerCount++;
			}
		}, 0, 1);
		Timer.instance().start();

		computer.init(map);
		view.setup();
	}
	
	public void placeTower(MA_Tower tower, int x, int y){
			tower.setPos(x, y);
			tower.getModel().transform.setTranslation(x * ME_TileState.tileDistance, 0.5f, y * ME_TileState.tileDistance);
			view.getTowerBatch().addElement(tower.getModel());
			computer.drawMoney(tower.getPrice());
			map.getTile(x, y).setTileState(ME_TileState.OCCUPIED);
			computer.updateDistancePathCount(map);
	}

	public void placeUnit(MA_Unit unit){
		M_Tile startTile = map.getPath().get(0);
		unit.setPos(startTile.x_pos, startTile.y_pos);
	}
}
