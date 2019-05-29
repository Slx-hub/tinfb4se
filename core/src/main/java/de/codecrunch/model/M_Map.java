package de.codecrunch.model;

import java.io.Serializable;
import java.util.List;
import java.util.function.Consumer;

public class M_Map implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -3304573725417148782L;
	
	private M_Tile[][] tiles;
    private List<M_Tile> path;
    private String mapName = "";
    public static final int X_COUNT = 20;
    public static final int Y_COUNT = 9;

    public M_Map() {
        tiles = new M_Tile[X_COUNT][Y_COUNT];
        for (int i = 0; i < X_COUNT; i++) {
            for (int j = 0; j < Y_COUNT; j++) {
                tiles[i][j] = new M_Tile(ME_TileState.EMPTY, i, j, 0);
            }
        }
    }

    public void foreachTile(Consumer<M_Tile> consumer) {
        for (int i = 0; i < X_COUNT; i++) {
            for (int j = 0; j < Y_COUNT; j++) {
                consumer.accept(tiles[i][j]);
            }
        }
    }

    public M_Tile getTile(int x, int y) {
        return tiles[x][y];
    }

    public M_Tile[][] getAllTiles() {
        return tiles;
    }

    public void setTile(M_Tile tile, int x, int y) {
        tiles[x][y] = tile;
    }

    public List<M_Tile> getPath() {
        return path;
    }

    public void setPath(List<M_Tile> path) {
        this.path = path;
    }

    public String getMapName() {
        return mapName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    public void deflate() {
        foreachTile(M_Tile::deflate);
    }

    public void inflate() {
        foreachTile(M_Tile::inflate);
    }
}
