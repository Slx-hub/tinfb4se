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
import de.codecrunch.controller.C_Game;
import de.codecrunch.model.unit.M_SmallUnit;


class V_HUD {

    private int digitCount;
    private float timeCount = 0;
    private Skin buttonSkins;
    private Table buttonTable;
    private Table labelTable;
    private String levelName;
    private int timer;
    private int resources;
    private String timerDesc;
    private String resourceDesc;
    private TextButton exit;
    private TextButton placeUnit;
    private Label level;
    private Label timerDescLabel;
    private Label resourceDescLabel;
    private Label worldTimer;
    private Label resourcesLabel;

    public V_HUD(C_Game controller,Stage stage, String levelName) {
        buttonSkins = new Skin(Gdx.files.internal("skins/neon/neon-ui.json"));
        this.levelName = "level: " + levelName;
        buildTopTable(controller);
        buildBottomTable(controller);
        addHudComponents(stage);
    }

    private void addHudComponents(Stage stage) {
        stage.addActor(labelTable);
        stage.addActor(buttonTable);
    }

    private void buildBottomTable(C_Game controller) {
        buttonTable = new Table();
        buttonTable.bottom();
        buttonTable.setFillParent(true);
        buildUnitButton(controller);
        buttonTable.add(placeUnit).left().expandX().padBottom(10).padLeft(10);


    }

    private void buildUnitButton(C_Game controller) {
        placeUnit = new TextButton("Place Unit", buttonSkins);
        placeUnit.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                controller.placeUnit(new M_SmallUnit());{

                }

            }

        });
    }

    private void buildTopTable(C_Game controller) {
        createLabels();
        TextButton exit = new TextButton("X", buttonSkins);
        labelTable = new Table();
        labelTable.top();
        labelTable.setFillParent(true);
        labelTable.add(level).expandX().padTop(10);
        labelTable.add(timerDescLabel).expandX().padTop(10);
        labelTable.add(resourceDescLabel).expandX().padTop(10);
        labelTable.add(exit).padTop(10);
        labelTable.row();
        labelTable.add(new Label("", new Label.LabelStyle(new BitmapFont(), Color.GREEN))).expandX();
        labelTable.add(worldTimer).expandX();
        labelTable.add(resourcesLabel).expandX();
    }

    private void createLabels() {

        digitCount = 0;
        resources = 99999;
        timer = 0;
        timerDesc = "timer";
        resourceDesc = "resources";
        level = new Label(levelName, new Label.LabelStyle(new BitmapFont(), Color.GREEN));
        timerDescLabel = new Label(timerDesc, new Label.LabelStyle(new BitmapFont(), Color.GREEN));
        worldTimer = new Label(String.format("%1d", timer), new Label.LabelStyle(new BitmapFont(), Color.GREEN));
        resourceDescLabel = new Label(resourceDesc, new Label.LabelStyle(new BitmapFont(), Color.GREEN));
        resourcesLabel = new Label(String.format("%5d", resources), new Label.LabelStyle(new BitmapFont(), Color.GREEN));
    }

    public void update(float dt){
        timeCount += dt;
        if(timeCount >= 1) {
            timer++;
            if(String.valueOf(timer).length() > digitCount){
                digitCount++;
            }
            worldTimer.setText(String.format("%"+digitCount+"d", timer));
            timeCount = 0;
        }
        }
    }



