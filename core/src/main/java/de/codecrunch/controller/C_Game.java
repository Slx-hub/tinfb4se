package de.codecrunch.controller;

import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import de.codecrunch.TowerAttackGame;
import de.codecrunch.model.ME_TileState;
import de.codecrunch.model.M_Base;
import de.codecrunch.model.M_Map;
import de.codecrunch.model.M_RenderBatch;
import de.codecrunch.model.M_Tile;
import de.codecrunch.model.M_User;
import de.codecrunch.model.tower.MA_Tower;
import de.codecrunch.model.unit.MA_Unit;
import de.codecrunch.view.V_Game;
import de.codecrunch.view.V_HUD;

public class C_Game {
    private M_User user = new M_User();
    private M_Base base = new M_Base();
    private V_HUD hud;
    private C_Computer computer = new C_Computer(this);
    private V_Game view;
    private M_Map map;
    private List<MA_Tower> towerList = new LinkedList<>();
    private List<MA_Unit> unitList = new LinkedList<>();

    public C_Game(TowerAttackGame game, M_Map map) {
        this.map = map;
    }

    public void setView(V_Game view) {
        this.view = view;
    }

    public void start() {
        M_RenderBatch mapBatch = view.getMapBatch();
        map.foreachTile(t -> {
            t.updateGameModel();
            mapBatch.addElement(t.getGameModel());
        });

        Timer.instance().scheduleTask(new Task() {
            private int timerCount = 0;

            @Override
            public void run() {
                timerCount++;
                int amount = 1 + timerCount / 30;
                computer.addMoney(amount * 2);
                user.addMoney(amount);

                hud.update(timerCount, user.getBalance(), base.getCurrentLife());

                computer.tick(timerCount);
            }
        }, 1, 1);
        Timer.instance().start();

        computer.init(map);
        hud = view.setup();
    }

    public void placeTower(MA_Tower tower, int x, int y) {
        tower.setPos(x, y);
        tower.getModel().transform.setTranslation(x * ME_TileState.TILE_DISTANCE, 0.5f, y * ME_TileState.TILE_DISTANCE);
        view.getTowerBatch().addElement(tower.getModel());
        view.addLaserLine(tower.getLaserLine());
        computer.drawMoney(tower.getPrice());
        map.getTile(x, y).setTileState(ME_TileState.OCCUPIED);
        computer.updateDistancePathCount(map);
        tower.setOwner(computer);
        towerList.add(tower);
        registerTowerOnMap(tower, x, y);
    }

    public void buyUnit(MA_Unit unit) {
        if (unit.getCost() <= user.getBalance()) {
            user.drawMoney(unit.getCost());
            view.getUnitBatch().addElement(unit.getModel());
            unit.setPath(map.getPath().iterator());
            unit.setGame(this);
            unitList.add(unit);
        }
    }

    public void removeUnit(MA_Unit unit) {
        view.getUnitBatch().removeElement(unit.getModel());
        unitList.remove(unit);
    }

    public void tick(float delta) {
        List<MA_Unit> deadUnits = new ArrayList<>();
        for (MA_Unit unit : unitList) {
            if (unit.isDead() || unit.isDone()) {
                deadUnits.add(unit);
                if (unit.isDone())
                    base.takeDamage();
            } else
                unit.tick(delta);
        }
        for (MA_Unit unit : deadUnits)
            removeUnit(unit);

        for (MA_Tower tower : towerList)
            tower.tick(delta);
    }

    private void registerTowerOnMap(MA_Tower tower, int x, int y) {
        int range = tower.getRange();
        for (int iy = Math.max(0, y - range); iy <= Math.min(M_Map.Y_COUNT - 1, y + range); iy++) {
            for (int ix = Math.max(0, x - range); ix <= Math.min(M_Map.X_COUNT - 1, x + range); ix++) {
                if (map.getTile(ix, iy).getTileState().getGroup() == ME_TileState.ME_TileStateGroup.PATH) {
                    map.getTile(ix, iy).registerTower(tower);
                }
            }
        }
    }

    public void yieldUnitMoney(int amount) {
        user.addMoney(amount);
    }

    public void healUnitsInRange(M_Tile position, int range) {
        System.out.println("Healing:");
        for (int x = Math.max(position.xPos - range, 0); x <= Math.min(position.xPos + range, M_Map.X_COUNT - 1); x++) {
            for (int y = Math.max(position.yPos - range, 0); y <= Math.min(position.yPos + range, M_Map.Y_COUNT - 1); y++) {
                map.getTile(x, y).getUnitsInTile().forEach(unit -> unit.heal(unit.getMaxLife() / 50));
            }
        }
    }
}
