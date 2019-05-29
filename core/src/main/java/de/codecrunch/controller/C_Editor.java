package de.codecrunch.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import de.codecrunch.TowerAttackGame;
import de.codecrunch.model.ME_TileState;
import de.codecrunch.model.M_Map;
import de.codecrunch.model.M_Path;
import de.codecrunch.model.M_Tile;
import de.codecrunch.view.VA_Screen;
import de.codecrunch.view.V_Editor;

public class C_Editor {

    private M_Map map;
    private V_Editor view;
    private M_Path<M_Tile> path = new M_Path<>();
    private boolean additive = true;
    private TowerAttackGame towerAttackGame;

    public C_Editor(TowerAttackGame game, M_Map m) {
        if (m != null) {
            map = m;
            path.addFromList(map.getPath());
        } else {
            map = new M_Map();
        }

        towerAttackGame = game;
        map.foreachTile(M_Tile::updateEditorImage);
    }

    public void setView(V_Editor view) {
        this.view = view;
    }

    public M_Map getMap() {
        return map;
    }

    public void setAdditive(boolean add) {
        additive = add;
    }

    public void clickedOnTile(M_Tile tile) {
        if (additive)
            addToPath(tile);
        else
            removeFromPath(tile);
    }

    public void addToPath(M_Tile tile) {
        if (tile.getTileState() != ME_TileState.EMPTY)
            return;
        if (path.isEmpty()) {
            path.addFront(tile);
            tile.setTileState(ME_TileState.START);
            tile.updateEditorImage();
            return;
        }
        M_Tile head = path.head().get();
        M_Tile tail = path.tail().get();
        if (neighbour(head, tile)) {
            path.addFront(tile);
            tile.setTileState(ME_TileState.END);
            tile.updateEditorImage();
            update(path.head());
            update(path.head().prev());
            return;
        }
        if (neighbour(tail, tile)) {
            path.addBack(tile);
            tile.setTileState(ME_TileState.START);
            tile.updateEditorImage();
            update(path.tail());
            update(path.tail().next());
        }
    }

    public void removeFromPath(M_Tile tile) {
        if (tile.getTileState() == ME_TileState.EMPTY)
            return;
        if (tile == path.head().get()) {
            path.head().get().setTileState(ME_TileState.EMPTY).updateEditorImage();
            M_Path<M_Tile>.Node newHead = path.head().prev();
            path.removeFront();
            if (newHead != null){
                newHead.get().setTileState(ME_TileState.END).updateEditorImage();
                if (newHead == path.tail())
                    newHead.get().setTileState(ME_TileState.START).updateEditorImage();
            }
        } else if (tile == path.tail().get()) {
            path.tail().get().setTileState(ME_TileState.EMPTY).updateEditorImage();
            M_Path<M_Tile>.Node newTail = path.tail().next();
            path.removeBack();
            if (newTail != null)
                newTail.get().setTileState(ME_TileState.START).updateEditorImage();
        }
    }

    private boolean neighbour(M_Tile t1, M_Tile t2) {
        return Math.abs(t1.xPos - t2.xPos) <= 1 && t1.yPos == t2.yPos || Math.abs(t1.yPos - t2.yPos) <= 1 && t1.xPos == t2.xPos;
    }

    private void update(M_Path<M_Tile>.Node node) {
        M_Tile neighbour;
        if (!node.hasPrev() && !node.hasNext())
            return;
        if (node.hasPrev())
            neighbour = node.prev().get();
        else
            neighbour = node.next().get();

        int rotation = (90 * (2 - (neighbour.yPos - node.get().yPos)) - (neighbour.xPos < node.get().xPos ? 180 : 0) + (!node.hasPrev() ? 180 : 0)) % 360;
        node.get().setTileRotation(rotation);

        if (node.hasPrev() && node.hasNext()) {
            int prevAngle = (node.get().xPos - node.prev().get().xPos + 1) * 90 + (node.get().yPos < node.prev().get().yPos ? 180 : 0);
            int nextAngle = (node.get().xPos - node.next().get().xPos + 1) * 90 + (node.get().yPos < node.next().get().yPos ? 180 : 0);
            int betweenAngle = (prevAngle - nextAngle) % 360;

            switch (betweenAngle) {
                case 180:
                case -180:
                    node.get().setTileState(ME_TileState.PATH_STRAIGHT);
                    break;
                case -90:
                case 270:
                    node.get().setTileState(ME_TileState.PATH_RIGHT);
                    break;
                case 90:
                case -270:
                    node.get().setTileState(ME_TileState.PATH_LEFT);
                    break;
                default:
                    break;
            }
        }
        node.get().updateEditorImage();
    }

    public void save() {
        TextField input = new TextField(map.getMapName(), VA_Screen.uiSkin);
        input.setMaxLength(9);
        Dialog dialog = new Dialog("Save Level", VA_Screen.uiSkin) {
            @Override
            public void result(Object obj) {
                if ((boolean) obj) {
                    saveLevel(input.getText());
                }
            }
        };
        dialog.text("Enter a level name:");
        dialog.getContentTable().row();
        dialog.getContentTable().add(input);
        dialog.button("Done", true);
        dialog.button("Back", false);
        view.showDialog(dialog);
    }

    public void saveLevel(String levelName) {
        if (levelName.length() < 1)
            return;
        File file = Gdx.files.local("maps/" + levelName + ".map").file();
        map.setMapName(levelName);
        map.setPath(path.addToList(new ArrayList<>()));
        try {
            file.getParentFile().mkdirs();
            file.createNewFile();
            try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(file))) {
                map.deflate();
                stream.writeObject(map);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        towerAttackGame.changeScreen(TowerAttackGame.SCREENID_EDITORLVLSELECT);
    }
}
