package de.codecrunch.controller;

import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

import de.codecrunch.model.M_ComputerInformation;
import de.codecrunch.model.M_Map;
import de.codecrunch.model.tower.MA_Tower;

public class C_Computer {
    private C_Game game;
    private M_ComputerInformation info = new M_ComputerInformation();
    public static final int MAX_RANGE = 3;

    private static int compare(MA_Tower o1, MA_Tower o2) {
        return Integer.compare(o1.getPrice(), o2.getPrice());
    }

    private enum CE_ComputerState {
        IDLE, WAITING, SAVING, DONE;
    }

    private CE_ComputerState computerState = CE_ComputerState.IDLE;

    private List<MA_Tower> towerList = MA_Tower.getAllTowers();

    /**
     * used to determine the next goal. until is used as time goal, as well as money goal
     */
    private int until;

    private int money = 0;

    public C_Computer(C_Game game) {
        this.game = game;

        // sorts the list of towers accortding to their price. this is useful for finding a suiting tower for the computers funds
        towerList.sort(C_Computer::compare);
    }

    public void tick(int gameTime) {
        switch (computerState) {
            case IDLE:
                //choose a random time to wait, so the computer doesn't spam towers
                until = gameTime + (int) (Math.random() * (5 + gameTime / 100));
                computerState = CE_ComputerState.WAITING;
                break;
            case WAITING:
                if (gameTime >= until) {
                    //if he's DONE WAITING, choose a tower that is in the range of the computers funds
                    until = Math.min(towerList.size() - 1, Math.max(0, getAffordable() + (int) (Math.random() * (4 + gameTime / 30) - 2)));
                    computerState = CE_ComputerState.SAVING;
                }
                break;
            case SAVING:
                if (money >= towerList.get(until).getPrice()) {
                    //if the tower has enough money, buy that tower
                    buyTower(towerList.get(until));
                    computerState = CE_ComputerState.IDLE;
                }
                break;
            case DONE:
                break;
        }
    }

    /**
     * @return the index of the first tower the computer can afford right now
     */
    private int getAffordable() {
        int i;
        for (i = 0; i < towerList.size() && money > towerList.get(i).getPrice(); i++) {
            // Empty on purpose
        }
        return i;
    }

    public void addMoney(int amount) {
        money += amount;
    }

    public void drawMoney(int amount) {
        money -= amount;
    }

    public void init(M_Map map) {
        info.init(map);
    }

    public void updateDistancePathCount(M_Map map) {
        info.updateDistancePathCount(map);
    }

    /**
     * finds the best position for that tower and places it
     *
     * @param tower to buy
     */
    private void buyTower(MA_Tower tower) {
        List<TreeSet<M_ComputerInformation.TowerTile>> topTiles = info.getTopTiles();

        //takes tower range as index for pcpr (as the last dimension describes range)
        int index = tower.getRange() - 1;

        //if the list of suitable tile for that specific range is empty, cycle though the other range lists until theres a free spot
        for (int offset = 0; topTiles.get(index).isEmpty() && offset < MAX_RANGE; offset++) {
            index = (tower.getRange() - 1 + offset) % MAX_RANGE;
        }

        //if there still is no suitable spot, the whole map is filled with towers, so computer can chill
        if (topTiles.get(index).isEmpty()) {
            computerState = CE_ComputerState.DONE;
            return;
        }

        Iterator<M_ComputerInformation.TowerTile> it = topTiles.get(index).iterator();
        M_ComputerInformation.TowerTile best = it.next();
        //chooses a random tile of the top tiles list (to make the placement less predictable, as top positions are the same each time for every map)
        for (int i = (int) (topTiles.get(index).size() * 2 / 3 + Math.random() * topTiles.get(index).size() / 3); i > 0; i--)
            if (it.hasNext())
                best = it.next();

        //try to instantiate a new tower of that type and let the game controller place it on the map
        try {
            game.placeTower(tower.getClass().newInstance(), best.x, best.y);

        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
