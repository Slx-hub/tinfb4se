package de.codecrunch.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

import de.codecrunch.model.ME_TileState.ME_TileStateGroup;
import de.codecrunch.model.M_Map;
import de.codecrunch.model.tower.MA_Tower;

public class C_Computer {
    private C_Game game;
    private final int maxRange = 3;

    private enum CE_ComputerState {
        idle, waiting, saving, done;
    }

    ;

    private CE_ComputerState computerState = CE_ComputerState.idle;

    /**
     * Path count per range. Saves the amount of path tiles in reach with 2
     * dimensions being the map axes and the third being the range of the tower.
     * Used to determine the best spots for the computer to place his tower
     */
    private byte[][][] pcpr;

    /**
     * lists the best tiles from pcpr, seperated by their ideal turret range
     */
    private List<TreeSet<TowerTile>> topTiles;

    private List<MA_Tower> towerList = MA_Tower.getAllTowers();

    /**
     * used to determine the next goal. until is used as time goal, as well as money goal
     */
    private int until;

    private int money = 0;

    public C_Computer(C_Game game) {
        this.game = game;

        // sorts the list of towers accortding to their price. this is useful for finding a suiting tower for the computers funds
        towerList.sort(new Comparator<MA_Tower>() {
            @Override
            public int compare(MA_Tower o1, MA_Tower o2) {
                return Integer.compare(o1.getPrice(), o2.getPrice());
            }
        });
    }

    public void tick(int gameTime) {
        switch (computerState) {
            case idle:
                //choose a random time to wait, so the computer doesn't spam towers
                until = gameTime + (int) (Math.random() * (5 + gameTime / 100));
                computerState = CE_ComputerState.waiting;
                break;
            case waiting:
                if (gameTime >= until) {
                    //if he's done waiting, choose a tower that is in the range of the computers funds
                    until = Math.min(towerList.size() - 1, Math.max(0, getAffordable() + (int) (Math.random() * (4 + gameTime / 30) - 2)));
                    computerState = CE_ComputerState.saving;
                }
                break;
            case saving:
                if (money >= towerList.get(until).getPrice()) {
                    //if the tower has enough money, buy that tower
                    buyTower(towerList.get(until));
                    computerState = CE_ComputerState.idle;
                }
                break;
        }
    }

    /**
     * @return the index of the first tower the computer can afford right now
     */
    private int getAffordable() {
        int i;
        for (i = 0; i < towerList.size() && money > towerList.get(i).getPrice(); i++) {
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
        pcpr = new byte[maxRange][M_Map.x_count][M_Map.y_count];
        updateDistancePathCount(map);
    }

    /**
     * finds the best position for that tower and places it
     *
     * @param tower to buy
     */
    private void buyTower(MA_Tower tower) {
        //takes tower range as index for pcpr (as the last dimension describes range)
        int index = tower.getRange() - 1;

        //if the list of suitable tile for that specific range is empty, cycle though the other range lists until theres a free spot
        for (int offset = 0; topTiles.get(index).isEmpty() && offset < maxRange; offset++) {
            index = (tower.getRange() - 1 + offset) % maxRange;
        }

        //if there still is no suitable spot, the whole map is filled with towers, so computer can chill
        if (topTiles.get(index).isEmpty()) {
            computerState = CE_ComputerState.done;
            return;
        }

        Iterator<TowerTile> it = topTiles.get(index).iterator();
        TowerTile best = it.next();
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

    /**
     * updates the computers internal map of suitable tiles to place turrets on
     *
     * @param map the real map
     */
    public void updateDistancePathCount(M_Map map) {
        //all it does is look for every tile on the map:
        //if empty, go around in the specified radius and have a look how many tiles of the PATH group are in there.
        //the PATHs in range will be counted and later sorted, to find the best tiles to place a turret on
        for (int distance = 1; distance <= pcpr.length; distance++) {
            for (int y = 0; y < M_Map.y_count; y++) {
                for (int x = 0; x < M_Map.x_count; x++) {
                    //if this spot is occupied, set the path count to -1 so it falls out of later comparison
                    if (map.getTile(x, y).getTileState().getGroup() != ME_TileStateGroup.EMPTY)
                        pcpr[distance - 1][x][y] = -1;
                    else {
                        //if the distance is > 1 there has been a pathcount noted for distance-1 so take that result and add the new ones to it
                        if (distance > 1)
                            pcpr[distance - 1][x][y] = pcpr[distance - 2][x][y];

                        for (int offset = 0; offset < distance * 2; offset++) {
                            pcpr[distance - 1][x][y] += countPaths(map, x, y, distance, offset);
                        }
                    }
                    //System.out.printf("%02d ", pcpr[distance - 1][x][y]);
                }
                //System.out.println();
            }
            //System.out.println();
        }
        findTopTiles();
    }

    /**
     * counts the found paths in the 4 specified locations
     *
     * @param map      the map
     * @param x        x location of the center
     * @param y        y location of the center
     * @param distance distance from the center
     * @param offset   distance from the center perpendicular to the distance param
     * @return count of path tiles
     */
    private byte countPaths(M_Map map, int x, int y, int distance, int offset) {
        byte total = 0;
        total += addIfPath(map, x - distance, y - distance + offset);
        total += addIfPath(map, x - distance + offset, y + distance);
        total += addIfPath(map, x + distance - offset, y - distance);
        total += addIfPath(map, x + distance, y + distance - offset);
        return total;
    }

    /**
     * checks for countPaths whether that tile is in range of the map, and if so check if that tile is a path
     * @param map
     * @param x
     * @param y
     * @return
     */
    private byte addIfPath(M_Map map, int x, int y) {
        if (x > 0 && x < M_Map.x_count && y > 0 && y < M_Map.y_count && map.getTile(x, y).getTileState().getGroup() == ME_TileStateGroup.PATH)
            return 1;
        else
            return 0;
    }

    /**
     * analyzes pcpr and filters out the top candidates for each range to save them in topTiles
     */
    private void findTopTiles() {
        topTiles = new ArrayList<TreeSet<TowerTile>>();
        for (int range = 1; range <= maxRange; range++) {
            topTiles.add(new TreeSet<>());
            for (int y = 0; y < M_Map.y_count; y++) {
                for (int x = 0; x < M_Map.x_count; x++) {
                    if (pcpr[range - 1][x][y] < 0)
                        continue;
                    if (topTiles.get(range - 1).size() < 10 || pcpr[range - 1][x][y] > topTiles.get(range - 1).first().count) {
                        if (topTiles.get(range - 1).size() >= 10)
                            topTiles.get(range - 1).remove(topTiles.get(range - 1).first());
                        topTiles.get(range - 1).add(new TowerTile(pcpr[range - 1][x][y], x, y));
                    }
                }
            }
        }
        //topTiles.forEach(set -> System.out.println(set.stream().map(tile -> tile.toString()).collect(Collectors.joining(" , "))));
    }

    /**
     * This class was made to make comparing of the tiles easier.
     */
    private class TowerTile implements Comparable<TowerTile> {

        private final int score, count, x, y;

        public TowerTile(int count, int x, int y) {
            this.count = count;
            this.x = x;
            this.y = y;
            //this score avoids turrets having equal scores for comparison by taking the map position into account
            score = count * M_Map.y_count * M_Map.x_count + y * M_Map.x_count + x;
        }

        @Override
        public String toString() {
            return "(" + count + "|" + x + "," + y + ")";
        }

        @Override
        public int compareTo(TowerTile o) {
            return Integer.compare(score, o.score);
        }
    }
}
