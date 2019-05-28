package de.codecrunch.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import de.codecrunch.TowerAttackGame;
import de.codecrunch.controller.C_Game;
import de.codecrunch.model.M_User;
import de.codecrunch.model.unit.M_SmallUnit;


public class V_HUD {

    private M_User user;
    private TowerAttackGame game;
    private Skin buttonSkins;
    private Table buttonTable;
    private Table labelTable;
    private String levelName;
    private String timerDesc;
    private String resourceDesc;
    private TextButton exit;
    private ImageButton buySmallUnit;
    private Label level;
    private Label timerDescLabel;
    private Label resourceDescLabel;
    private Label worldTimer;
    private Label resourcesLabel;

    public V_HUD(C_Game controller, Stage stage, String levelName, M_User user, TowerAttackGame game) {
        buttonSkins = new Skin(Gdx.files.internal("skins/neon/neon-ui.json"));
        this.levelName = "level: " + levelName;
        buildTopTable(controller);
        buildBottomTable(controller);
        addHudComponents(stage);
        this.user = user;
        this.game = game;
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
        buttonTable.add(buySmallUnit).left().expandX().padBottom(10).padLeft(10);


    }

    private void buildUnitButton(C_Game controller) {
        buySmallUnit = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("ui/buySmallUnitButton.png")))));
        buySmallUnit.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                controller.buyUnit(new M_SmallUnit());
                {

                }

            }

        });
    }
    private void buildExitButton() {
        exit = new TextButton("Exit", buttonSkins);
        exit.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.changeScreen(2);
            }
        });
    }


    private void buildTopTable(C_Game controller) {
        createLabels();
        buildExitButton();
        labelTable = new Table();
        labelTable.top();
        labelTable.setFillParent(true);
        labelTable.add(level).expandX().padTop(10);
        labelTable.add(timerDescLabel).expandX().padTop(10);
        labelTable.add(resourceDescLabel).expandX().padTop(10);
        labelTable.add(exit).expandX().right();
        labelTable.row();
        labelTable.add(new Label("", new Label.LabelStyle(new BitmapFont(), Color.GREEN))).expandX();
        labelTable.add(worldTimer).expandX();
        labelTable.add(resourcesLabel).expandX();
    }


    private void createLabels() {
        timerDesc = "Time";
        resourceDesc = "Balance";
        level = new Label(levelName, new Label.LabelStyle(new BitmapFont(), Color.GREEN));
        timerDescLabel = new Label(timerDesc, new Label.LabelStyle(new BitmapFont(), Color.GREEN));
        worldTimer = new Label(String.format("%5d", 0), new Label.LabelStyle(new BitmapFont(), Color.GREEN));
        resourceDescLabel = new Label(resourceDesc, new Label.LabelStyle(new BitmapFont(), Color.GREEN));
        resourcesLabel = new Label(String.format("%5d", 0), new Label.LabelStyle(new BitmapFont(), Color.GREEN));
    }

    public void setTime(int time) {
        worldTimer.setText(String.format("%5d", time));
    }

    public void update() {
        resourcesLabel.setText(String.format("%5d", user.getBalance()));
    }
}



