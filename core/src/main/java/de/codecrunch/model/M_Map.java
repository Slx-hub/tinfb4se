package de.codecrunch.model;

import java.io.Serializable;
import java.util.List;
import java.util.function.Consumer;

public class M_Map implements Serializable {
    private M_Tile[][] tiles;
    private List<M_Tile> path;
    private String mapName = "";
    public final int x_count = 20;
    public final int y_count = 9;

    public M_Map() {
        tiles = new M_Tile[x_count][y_count];
        for (int i = 0; i < x_count; i++) {
            for (int j = 0; j < y_count; j++) {
                tiles[i][j] = new M_Tile(ME_TileState.EMPTY, i, j, 0);
            }
        }
    }

    public void foreachTile(Consumer<M_Tile> consumer) {
        for (int i = 0; i < x_count; i++) {
            for (int j = 0; j < y_count; j++) {
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
        foreachTile(new Consumer<M_Tile>() {
            @Override
            public void accept(M_Tile m_tile) {
                m_tile.deflate();
            }
        });
    }

    public void inflate() {
        foreachTile(new Consumer<M_Tile>() {
            @Override
            public void accept(M_Tile m_tile) {
                m_tile.inflate();
            }
        });
    }
}
