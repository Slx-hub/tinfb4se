package de.codecrunch.view;

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
import de.codecrunch.model.unit.M_BigUnit;
import de.codecrunch.model.unit.M_FastUnit;
import de.codecrunch.model.unit.M_MediumUnit;
import de.codecrunch.model.unit.M_SmallUnit;


public class V_HUD {

    private TowerAttackGame game;
    private Skin buttonSkins;
    private Table buttonTable;
    private Table labelTable;
    private ImageButton buySmallUnit;
    private ImageButton buyMediumUnit;
    private ImageButton buyBigUnit;
    private ImageButton buyFastUnit;
    private ImageButton quitGame;
    private String baseHealthDesc = "Base Health: ";
    private Label baseHealth;
    private String timerDesc = "Time: ";
    private Label worldTimer;
    private String resourceDesc = "Balance: ";
    private Label resources;

    public V_HUD(C_Game controller, Stage stage, TowerAttackGame game) {
        buttonSkins = new Skin(Gdx.files.internal("skins/neon/neon-ui.json"));
        buildButtons(controller);
        buildTopTable(controller);
        buildBottomTable(controller);

        addHudComponents(stage);
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
        buttonTable.add(buySmallUnit).size(150, 150).left().padBottom(10).padLeft(10);
        buttonTable.add(buyFastUnit).size(150, 150).left().padBottom(10).padLeft(10);
        buttonTable.add(buyMediumUnit).size(150, 150).left().padBottom(10).padLeft(10);
        buttonTable.add(buyBigUnit).size(150, 150).left().padBottom(10).padLeft(10);
    }

    private void buildButtons(C_Game controller) {
        buySmallUnit = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("ui/buySmallUnitButton.png")))));
        buyFastUnit = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("ui/buyFastUnitButton.png")))));
        buyMediumUnit = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("ui/buyMediumUnitButton.png")))));
        buyBigUnit = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("ui/buyBigUnitButton.png")))));
        quitGame = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("ui/quitButton.png")))));

        buySmallUnit.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                controller.buyUnit(new M_SmallUnit());
            }

        });
        buyFastUnit.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                controller.buyUnit(new M_FastUnit());
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
        quitGame.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.changeScreen(2);
            }
        });
    }


    private void buildTopTable(C_Game controller) {
        createLabels();
        labelTable = new Table();
        labelTable.setBackground(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("ui/topBarBackground.png")))));
        labelTable.top().left();
        labelTable.defaults().uniformX().pad(10,0,0,90);
        labelTable.setFillParent(true);
        labelTable.add(worldTimer);
        labelTable.add(resources);
        labelTable.add(baseHealth);
        labelTable.add(quitGame);
    }

    BitmapFont createFont(FreeTypeFontGenerator ftfg, float dp) {
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = (int) (dp * Gdx.graphics.getDensity());
        return ftfg.generateFont(parameter);
    }
    //On Init

    private void createLabels() {
        BitmapFont font = createFont(new FreeTypeFontGenerator(Gdx.files.internal("font/arial.ttf")), 64);
        worldTimer = new Label(timerDesc + String.format("%5d", 0), new Label.LabelStyle(font, Color.GREEN));
        resources = new Label(resourceDesc + String.format("%5d", 50), new Label.LabelStyle(font, Color.GREEN));
        baseHealth = new Label(baseHealthDesc + String.format("%2d", 20), new Label.LabelStyle(font, Color.GREEN));
    }

    public void update(int time, int balance, int health) {
        worldTimer.setText(timerDesc + String.format("%4d", time));
        resources.setText(resourceDesc + String.format("%5d", balance));
        baseHealth.setText(baseHealthDesc + String.format("%2d", health));
    }
}


