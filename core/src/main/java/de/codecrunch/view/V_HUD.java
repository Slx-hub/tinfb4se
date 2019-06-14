package de.codecrunch.view;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
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
import de.codecrunch.model.unit.M_BigUnit;
import de.codecrunch.model.unit.M_MediumUnit;
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
    private ImageButton buyMediumUnit;
    private ImageButton buyBigUnit;
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
        buildUnitButtons(controller);
        buttonTable.add(buySmallUnit).left().padBottom(10).padLeft(10);
        buttonTable.add(buyMediumUnit).left().padBottom(10).padLeft(10);
        buttonTable.add(buyBigUnit).left().padBottom(10).padLeft(10);

    }

    private void buildUnitButtons(C_Game controller) {
        buySmallUnit = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("ui/buySmallUnitButton.png")))));
        buyMediumUnit = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("ui/buyMediumUnitButton.png")))));
        buyBigUnit = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("ui/buyBigUnitButton.png")))));

        buySmallUnit.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                controller.buyUnit(new M_SmallUnit());
            }

        });
        buyMediumUnit.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                controller.buyUnit(new M_MediumUnit());
            }
        });
        buyBigUnit.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                controller.buyUnit(new M_BigUnit());
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
        labelTable.add(level).padTop(10).left().padLeft(20f);
        labelTable.add(timerDescLabel).padTop(10).expandX().center();
        labelTable.add(resourceDescLabel).padTop(10).padRight(20f);
        labelTable.add(exit).right();
        labelTable.row();
        labelTable.add(new Label("", new Label.LabelStyle(new BitmapFont(), Color.GREEN)));
        labelTable.add(worldTimer);
        labelTable.add(resourcesLabel);
    }
    BitmapFont createFont(FreeTypeFontGenerator ftfg, float dp) {
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        switch (Gdx.app.getType()) {
            case Android:
                parameter.size = (int) (dp * Gdx.graphics.getDensity());
            case Desktop:
                parameter.size = (int) dp;

        }
        return ftfg.generateFont(parameter);
    }
    //On Init

        private void createLabels() {
        timerDesc = "Time";
        resourceDesc = "Balance";
        BitmapFont font = createFont(new FreeTypeFontGenerator(Gdx.files.internal("font/arial.ttf")), 32);
        level = new Label(levelName, new Label.LabelStyle(font, Color.GREEN));
        timerDescLabel = new Label(timerDesc, new Label.LabelStyle(font, Color.GREEN));
        worldTimer = new Label(String.format("%5d", 0), new Label.LabelStyle(font, Color.GREEN));
        resourceDescLabel = new Label(resourceDesc, new Label.LabelStyle(font, Color.GREEN));
        resourcesLabel = new Label(String.format("%5d", 0), new Label.LabelStyle(font, Color.GREEN));
    }

    public void setTime(int time) {
        worldTimer.setText(String.format("%5d", time));
    }

    public void update() {
        resourcesLabel.setText(String.format("%5d", user.getBalance()));
    }
}


