package de.codecrunch.model;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import de.codecrunch.controller.C_Computer;

public class M_ComputerInformation {

    /**
     * Path count per range. Saves the amount of path tiles in reach with 2
     * dimensions being the map axes and the third being the range of the tower.
     * Used to determine the best spots for the computer to place his tower
     */
    private byte[][][] pcpr;

    /**
     * lists the best tiles from pcpr, seperated by their ideal turret range
     */
    private List<TreeSet<M_ComputerInformation.TowerTile>> topTiles;

    public List<TreeSet<M_ComputerInformation.TowerTile>> getTopTiles() {
        return topTiles;
    }

    public void init(M_Map map) {
        pcpr = new byte[C_Computer.MAX_RANGE][M_Map.X_COUNT][M_Map.Y_COUNT];
        updateDistancePathCount(map);
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
            for (int y = 0; y < M_Map.Y_COUNT; y++) {
                for (int x = 0; x < M_Map.X_COUNT; x++) {
                    //if this spot is occupied, set the path count to -1 so it falls out of later comparison
                    if (map.getTile(x, y).getTileState().getGroup() != ME_TileState.ME_TileStateGroup.EMPTY)
                        pcpr[distance - 1][x][y] = -1;
                    else {
                        //if the distance is > 1 there has been a pathcount noted for distance-1 so take that result and add the new ones to it
                        if (distance > 1)
                            pcpr[distance - 1][x][y] = pcpr[distance - 2][x][y];

                        for (int offset = 0; offset < distance * 2; offset++) {
                            pcpr[distance - 1][x][y] += countPaths(map, x, y, distance, offset);
                        }
                    }
                }
            }
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
     *
     * @param map
     * @param x
     * @param y
     * @return
     */
    private byte addIfPath(M_Map map, int x, int y) {
        if (x > 0 && x < M_Map.X_COUNT && y > 0 && y < M_Map.Y_COUNT && map.getTile(x, y).getTileState().getGroup() == ME_TileState.ME_TileStateGroup.PATH)
            return 1;
        else
            return 0;
    }

    /**
     * analyzes pcpr and filters out the top candidates for each range to save them in topTiles
     */
    private void findTopTiles() {
        topTiles = new ArrayList<TreeSet<TowerTile>>();
        for (int range = 1; range <= C_Computer.MAX_RANGE; range++) {
            TreeSet<TowerTile> topTileSet = new TreeSet<>();
            topTiles.add(topTileSet);
            for (int y = 0; y < M_Map.Y_COUNT; y++) {
                for (int x = 0; x < M_Map.X_COUNT; x++) {
                    if (pcpr[range - 1][x][y] < 0)
                        continue;
                    if (topTileSet.size() < 10 || pcpr[range - 1][x][y] > topTileSet.first().count) {
                        if (topTileSet.size() >= 10)
                            topTileSet.remove(topTileSet.first());
                        topTileSet.add(new TowerTile(pcpr[range - 1][x][y], x, y));
                    }
                }
            }
        }
    }

    /**
     * This class was made to make comparing of the tiles easier.
     */
    public class TowerTile implements Comparable<TowerTile> {

        public final int score, count, x, y;

        public TowerTile(int count, int x, int y) {
            this.count = count;
            this.x = x;
            this.y = y;
            //this score avoids turrets having equal scores for comparison by taking the map position into account
            score = count * M_Map.Y_COUNT * M_Map.X_COUNT + y * M_Map.X_COUNT + x;
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
