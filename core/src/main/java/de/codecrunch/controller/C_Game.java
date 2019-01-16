package de.codecrunch.controller;

import java.util.function.Consumer;

import de.codecrunch.TowerAttackGame;
import de.codecrunch.model.M_Game;
import de.codecrunch.model.M_Map;
import de.codecrunch.model.M_MapBatch;
import de.codecrunch.model.M_Tile;
import de.codecrunch.view.V_Game;

public class C_Game {
    private M_Game model = new M_Game();
    private V_Game view;
    private TowerAttackGame towerAttackGame;
    private M_Map map;
    
    public static final float MID_MAP = 25.3f;
    public static final float LOWER_END = 20.3f;
    public static final float UPPER_END = 169.6f;
    
    
    public C_Game(TowerAttackGame game, M_Map map){
    	towerAttackGame = game;
    	this.map = map;
    }
    
    public void setView(V_Game view) {
        this.view = view;
    }
    
    public void start(){
    	M_MapBatch mapBatch = view.getMapBatch();
    	map.foreachTile(new Consumer<M_Tile>() {	
			@Override
			public void accept(M_Tile t) {
				t.updateGameModel();
				mapBatch.addTile(t.getGameModel());
			}
		});
    	
    	view.setup();
    }
}
