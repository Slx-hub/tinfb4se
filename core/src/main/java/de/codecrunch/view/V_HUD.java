package de.codecrunch.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import java.util.ArrayList;
import java.util.List;

import de.codecrunch.controller.C_Game;
import de.codecrunch.model.unit.MA_Unit;
import de.codecrunch.model.unit.M_SmallUnit;


public class V_HUD {

    private Table buttonTable;
    private Stage stage;
    private C_Game controller;
    public Table labelTable;
    private String levelName = ">Insert level name here<";
    private int timer;
    private int resources;
    private String timerDesc;
    private String resourceDesc;
    public TextButton placeTower;
    Label level;
    Label timerDescLabel;
    Label resourceDescLabel;
    Label worldTimer;
    Label resourcesLabel;
    List<Table> hudComponents;
    public V_HUD(C_Game controller,Stage stage) {
        this.resources = 99999;
        this.timer = 99999;
        this.timerDesc = "timer";
        this.resourceDesc = "resources";
        this.stage = stage;
        this.labelTable = new Table();
        this.hudComponents = new ArrayList<>();
        labelTable.top();
        labelTable.setFillParent(true);

        level = new Label(levelName, new Label.LabelStyle(new BitmapFont(), Color.GREEN));
        timerDescLabel = new Label(timerDesc, new Label.LabelStyle(new BitmapFont(), Color.GREEN));
        worldTimer = new Label(String.format("%05d", timer), new Label.LabelStyle(new BitmapFont(), Color.GREEN));
        resourceDescLabel = new Label(resourceDesc, new Label.LabelStyle(new BitmapFont(), Color.GREEN));
        resourcesLabel = new Label(String.format("%05d", resources), new Label.LabelStyle(new BitmapFont(), Color.GREEN));


        Skin buttonSkins = new Skin(Gdx.files.internal("skins/neon/neon-ui.json"));
        this.placeTower = new TextButton("Place Tower", buttonSkins);
        labelTable.add(level).expandX().padTop(10);
        labelTable.add(timerDescLabel).expandX().padTop(10);
        labelTable.add(resourceDescLabel).expandX().padTop(10);
        labelTable.row();
        labelTable.add(new Label("", new Label.LabelStyle(new BitmapFont(), Color.GREEN))).expandX().padTop(10);
        labelTable.add(worldTimer).expandX().padTop(10);
        labelTable.add(resourcesLabel).expandX().padTop(10);
        this.placeTower.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                controller.placeUnit(new M_SmallUnit()); {

                }

            }

        });
        this.buttonTable = new Table();
        buttonTable.bottom();
        buttonTable.setFillParent(true);
        buttonTable.add(placeTower).left().expandX().padBottom(10).padLeft(10);
        this.placeTower = new TextButton("Place Unit", buttonSkins);
        stage.addActor(labelTable);
        stage.addActor(buttonTable);
    }


}
