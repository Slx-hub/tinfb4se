package de.codecrunch.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

import de.codecrunch.model.ME_TileState.ME_TileStateGroup;
import de.codecrunch.model.M_Map;

public class C_Computer {
	private C_Game game;

	/**
	 * Path count per distance. Saves the amount of path tiles in reach with 2
	 * dimensions being the map axes and the third being the range
	 */
	private final int maxRange = 3;

	private byte[][][] pcpd;
	private List<TreeSet<TowerTile>> topTiles;

	private int money = 0;

	public C_Computer(C_Game game) {
		this.game = game;
	}

	public void addMoney(int amount) {
		money += amount;
	}

	public void init(M_Map map) {
		pcpd = new byte[maxRange][map.x_count][map.y_count];
		updateDistancePathCount(map);
	}

	private void updateDistancePathCount(M_Map map) {
		for (int distance = 1; distance <= pcpd.length; distance++) {
			for (int y = 0; y < map.y_count; y++) {
				for (int x = 0; x < map.x_count; x++) {
					if (map.getTile(x, y).getTileState().getGroup() != ME_TileStateGroup.EMPTY)
						pcpd[distance - 1][x][y] = -1;
					else {
						if (distance > 1)
							pcpd[distance - 1][x][y] = pcpd[distance - 2][x][y];
						for (int count = 0; count < distance * 2; count++) {
							pcpd[distance - 1][x][y] += countPaths(map, x, y, distance, count);
						}
					}
					System.out.printf("%02d ", pcpd[distance - 1][x][y]);
				}
				System.out.println();
			}
			System.out.println();
		}
		findTopTiles(map);
	}

	private byte countPaths(M_Map map, int x, int y, int distance, int offset) {
		byte total = 0;
		total += addIfPath(map, x - distance, y - distance + offset);
		total += addIfPath(map, x - distance + offset, y + distance);
		total += addIfPath(map, x + distance - offset, y - distance);
		total += addIfPath(map, x + distance, y + distance - offset);
		return total;
	}

	private byte addIfPath(M_Map map, int x, int y) {
		if (x > 0 && x < map.x_count && y > 0 && y < map.y_count && map.getTile(x, y).getTileState().getGroup() == ME_TileStateGroup.PATH)
			return 1;
		else
			return 0;
	}

	private void findTopTiles(M_Map map) {
		topTiles = new ArrayList<TreeSet<TowerTile>>();
		for (int range = 1; range <= maxRange; range++) {
			topTiles.add(new TreeSet<>());
			for (int y = 0; y < map.y_count; y++) {
				for (int x = 0; x < map.x_count; x++) {
					if (pcpd[range - 1][x][y] < 0)
						continue;
					if (topTiles.get(range - 1).size() <= 10 || pcpd[range - 1][x][y] > topTiles.get(range - 1).first().count) {
						if (topTiles.get(range - 1).size() > 10)
							topTiles.get(range - 1).remove(topTiles.get(range - 1).first());
						topTiles.get(range - 1).add(new TowerTile(pcpd[range - 1][x][y], x, y));
					}
				}
			}
		}
		topTiles.forEach(set -> System.out.println(set.stream().map(tile -> tile.toString()).collect(Collectors.joining(" , "))));
	}

	private class TowerTile implements Comparable<TowerTile>{

		private final int count, x, y;

		public TowerTile(int count, int x, int y) {
			this.count = count;
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "(" + count + "|" + x + "," + y + ")";
		}

		@Override
		public int compareTo(TowerTile o) {
			return Integer.compare(count, o.count);
		}
	}
}
