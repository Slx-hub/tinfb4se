package de.codecrunch.view;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import de.codecrunch.TowerAttackGame;
import de.codecrunch.controller.C_Editor;
import de.codecrunch.model.M_Map;
import de.codecrunch.model.M_Tile;

public class V_Editor extends VA_Screen {
	private C_Editor controller;

	private InputListener tileListener = new InputListener() {
		@Override
		public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
			if (event.getListenerActor() instanceof M_Tile && pointer >= 0)
				controller.clickedOnTile((M_Tile) event.getListenerActor());
		}
	};

	public V_Editor(TowerAttackGame game) {
		super(game);
	}

	public V_Editor loadUI() {
		Table uiTable = new Table();
		Table mapTable = new Table();

		stage.addActor(uiTable);
		uiTable.setFillParent(true);
		uiTable.add(mapTable).colspan(4);

		M_Tile[][] tiles = controller.getMap().getAllTiles();
		for (int y = 0; y < M_Map.Y_COUNT; y++) {
			for (int x = 0; x < M_Map.X_COUNT; x++) {
				final M_Tile m_tile = tiles[x][y];
				mapTable.add(m_tile).center();
				m_tile.addListener(tileListener);
			}
			mapTable.row();
		}
		uiTable.row().padTop(20);

		TextButton add = new TextButton("ADD", uiSkin);
		TextButton remove = new TextButton("REMOVE", uiSkin);
		TextButton exit = new TextButton("Exit", uiSkin);
		TextButton save = new TextButton("Save", uiSkin);

		uiTable.add(add).right();
		uiTable.add(remove).left();
		uiTable.add(exit).right();
		uiTable.add(save).left();

		add.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				controller.setAdditive(true);
			}
		});
		remove.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				controller.setAdditive(false);
			}
		});
		exit.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				towerAttackGame.changeScreen(TowerAttackGame.SCREENID_EDITORLVLSELECT);
			}
		});
		save.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				controller.save();
			}
		});
		return this;
	}

	public void setController(C_Editor controller) {
		this.controller = controller;
	}

	@Override
	public void show() {
		// Empty on purpose
	}

}
