package de.codecrunch.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.function.Consumer;

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
        map.foreachTile(new Consumer<M_Tile>() {
            @Override
            public void accept(M_Tile m_tile) {
                m_tile.updateEditorImage();
            }
        });
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
            tile.setTileState(ME_TileState.END);
            tile.updateEditorImage();
            return;
        }
        M_Tile head = path.head().get();
        M_Tile tail = path.tail().get();
        if (neighbour(head, tile)) {
            path.addFront(tile);
            tile.setTileState(ME_TileState.END);
            tile.updateEditorImage();
            update(path.head().prev());
            return;
        }
        if (neighbour(tail, tile)) {
            path.addBack(tile);
            tile.setTileState(ME_TileState.END);
            tile.updateEditorImage();
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
            if (newHead != null)
                newHead.get().setTileState(ME_TileState.END).updateEditorImage();
        } else if (tile == path.tail().get()) {
            path.tail().get().setTileState(ME_TileState.EMPTY).updateEditorImage();
            M_Path<M_Tile>.Node newTail = path.tail().next();
            path.removeBack();
            if (newTail != null)
                newTail.get().setTileState(ME_TileState.END).updateEditorImage();
        }
    }

    private boolean neighbour(M_Tile t1, M_Tile t2) {
        return Math.abs(t1.x_pos - t2.x_pos) <= 1 && t1.y_pos == t2.y_pos || Math.abs(t1.y_pos - t2.y_pos) <= 1 && t1.x_pos == t2.x_pos;
    }

    private void update(M_Path<M_Tile>.Node node) {
        if (!node.hasNext() || !node.hasPrev())
            return;
        int rotation = 90 * (2 - (node.prev().get().y_pos - node.get().y_pos)) - (node.prev().get().x_pos < node.get().x_pos ? 180 : 0);
        node.get().setTileRotation(rotation);
        if (node.prev().get().x_pos == node.next().get().x_pos || node.prev().get().y_pos == node.next().get().y_pos) {
            node.get().setTileState(ME_TileState.PATH_STRAIGHT).updateEditorImage();
            return;
        }
        //might get refactored later
        if (node.prev().get().x_pos == node.get().x_pos) {
            if (node.prev().get().y_pos < node.get().y_pos) {
                if (node.next().get().x_pos < node.get().x_pos) {
                    node.get().setTileState(ME_TileState.PATH_RIGHT);
                } else {
                    node.get().setTileState(ME_TileState.PATH_LEFT);
                }
            } else {
                if (node.next().get().x_pos > node.get().x_pos) {
                    node.get().setTileState(ME_TileState.PATH_RIGHT);
                } else {
                    node.get().setTileState(ME_TileState.PATH_LEFT);
                }
            }
        } else {
            if (node.prev().get().x_pos < node.get().x_pos) {
                if (node.next().get().y_pos > node.get().y_pos) {
                    node.get().setTileState(ME_TileState.PATH_RIGHT);
                } else {
                    node.get().setTileState(ME_TileState.PATH_LEFT);
                }
            } else {
                if ((node.next().get().y_pos < node.get().y_pos)) {
                    node.get().setTileState(ME_TileState.PATH_RIGHT);
                } else {
                    node.get().setTileState(ME_TileState.PATH_LEFT);
                }
            }
        }
        node.get().updateEditorImage();
    }

    public void save() {
        TextField input = new TextField("", view.uiSkin);
        input.setMaxLength(9);
        Dialog dialog = new Dialog("Save Level", view.uiSkin) {
            @Override
            public void result(Object obj) {
                if ((boolean) obj) {
                    towerAttackGame.changeScreen(TowerAttackGame.SCREENID_EDITORLVLSELECT);
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
        File file = Gdx.files.local("maps/" + levelName + ".map").file();
        if (file.exists()) {
            Dialog dialog = new Dialog("Lol, nope", view.uiSkin);
            dialog.text("A level with this name already exists");
            dialog.button("Okay");
            view.showDialog(dialog);
            return;
        }
        map.setPath(path.addToList(new ArrayList<>()));
        try {
            file.getParentFile().mkdirs();
            file.createNewFile();
            ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(file));
            map.deflate();
            stream.writeObject(map);
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
