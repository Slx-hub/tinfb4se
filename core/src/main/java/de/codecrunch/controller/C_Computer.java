package de.codecrunch.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

import de.codecrunch.model.ME_TileState.ME_TileStateGroup;
import de.codecrunch.model.M_Map;
import de.codecrunch.model.tower.MA_Tower;

public class C_Computer {
	private C_Game game;
	private final int maxRange = 3;

	private enum CE_ComputerState {
		idle, waiting, saving, done;
	};

	private CE_ComputerState computerState = CE_ComputerState.idle;

	/**
	 * Path count per distance. Saves the amount of path tiles in reach with 2
	 * dimensions being the map axes and the third being the range
	 */
	private byte[][][] pcpd;
	private List<TreeSet<TowerTile>> topTiles;

	private List<MA_Tower> towerList = MA_Tower.getAllTowers();

	private int until;
	private int money = 0;

	public C_Computer(C_Game game) {
		this.game = game;

		towerList.sort(new Comparator<MA_Tower>() {
			@Override
			public int compare(MA_Tower o1, MA_Tower o2) {
				return Integer.compare(o1.getPrice(), o2.getPrice());
			}
		});
	}

	public void tick(int timerCount) {
		switch (computerState) {
		case idle:
			until = timerCount + (int) (Math.random() * (5 + timerCount / 100));
			computerState = CE_ComputerState.waiting;
			break;
		case waiting:
			if (timerCount >= until) {
				until = Math.min(towerList.size() - 1, Math.max(0, getAffordable() + (int) (Math.random() * (4 + timerCount / 30) - 2)));
				computerState = CE_ComputerState.saving;
			}
			break;
		case saving:
			if (money >= towerList.get(until).getPrice()) {
				buyTower(towerList.get(until));
				computerState = CE_ComputerState.idle;
			}
			break;
		}
	}

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
		pcpd = new byte[maxRange][M_Map.x_count][M_Map.y_count];
		updateDistancePathCount(map);
	}

	private void buyTower(MA_Tower tower) {
		int index = tower.getRange() - 1;
		for (int offset = 0; topTiles.get(index).isEmpty() && offset < maxRange; offset++) {
			index = (tower.getRange() - 1 + offset) % maxRange;
		}
		if (topTiles.get(index).isEmpty())
			computerState = CE_ComputerState.done;
		else {
			Iterator<TowerTile> it = topTiles.get(index).iterator();
			for (int i = (int) (topTiles.get(index).size() * 2 / 3 + Math.random() * topTiles.get(index).size() / 3); i > 0; i--)
				if (it.hasNext())
					it.next();
			TowerTile best = it.next();
			try {
				game.placeTower(tower.getClass().newInstance(), best.x, best.y);
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}

	public void updateDistancePathCount(M_Map map) {
		for (int distance = 1; distance <= pcpd.length; distance++) {
			for (int y = 0; y < M_Map.y_count; y++) {
				for (int x = 0; x < M_Map.x_count; x++) {
					if (map.getTile(x, y).getTileState().getGroup() != ME_TileStateGroup.EMPTY)
						pcpd[distance - 1][x][y] = -1;
					else {
						if (distance > 1)
							pcpd[distance - 1][x][y] = pcpd[distance - 2][x][y];
						for (int count = 0; count < distance * 2; count++) {
							pcpd[distance - 1][x][y] += countPaths(map, x, y, distance, count);
						}
					}
					//System.out.printf("%02d ", pcpd[distance - 1][x][y]);
				}
				//System.out.println();
			}
			//System.out.println();
		}
		findTopTiles();
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
		if (x > 0 && x < M_Map.x_count && y > 0 && y < M_Map.y_count && map.getTile(x, y).getTileState().getGroup() == ME_TileStateGroup.PATH)
			return 1;
		else
			return 0;
	}

	private void findTopTiles() {
		topTiles = new ArrayList<TreeSet<TowerTile>>();
		for (int range = 1; range <= maxRange; range++) {
			topTiles.add(new TreeSet<>());
			for (int y = 0; y < M_Map.y_count; y++) {
				for (int x = 0; x < M_Map.x_count; x++) {
					if (pcpd[range - 1][x][y] < 0)
						continue;
					if (topTiles.get(range - 1).size() < 10 || pcpd[range - 1][x][y] > topTiles.get(range - 1).first().count) {
						if (topTiles.get(range - 1).size() >= 10)
							topTiles.get(range - 1).remove(topTiles.get(range - 1).first());
						topTiles.get(range - 1).add(new TowerTile(pcpd[range - 1][x][y], x, y));
					}
				}
			}
		}
		//topTiles.forEach(set -> System.out.println(set.stream().map(tile -> tile.toString()).collect(Collectors.joining(" , "))));
	}

	private class TowerTile implements Comparable<TowerTile> {

		private final int score, count, x, y;

		public TowerTile(int count, int x, int y) {
			this.count = count;
			this.x = x;
			this.y = y;
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
