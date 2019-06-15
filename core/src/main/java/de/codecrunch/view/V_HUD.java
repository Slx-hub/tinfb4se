package de.codecrunch.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import de.codecrunch.TowerAttackGame;
import de.codecrunch.controller.C_Game;
import de.codecrunch.model.unit.M_BigUnit;
import de.codecrunch.model.unit.M_FastUnit;
import de.codecrunch.model.unit.M_HealUnit;
import de.codecrunch.model.unit.M_MediumUnit;
import de.codecrunch.model.unit.M_SmallUnit;


public class V_HUD {

    private final int maxHealth;
    private ProgressBar lifeBar;
    private TowerAttackGame game;
    private Table buttonTable;
    private Table labelTable;
    private ImageButton buySmallUnit;
    private ImageButton buyMediumUnit;
    private ImageButton buyBigUnit;
    private ImageButton buyFastUnit;
    private ImageButton buyHealUnit;
    private ImageButton quitGame;
    private String baseHealthDesc = "Base Health: ";
    private Label baseHealth;
    private String timerDesc = "Time: ";
    private Label worldTimer;
    private String resourceDesc = "Balance: ";
    private Label resources;

    public V_HUD(C_Game controller, Stage stage, TowerAttackGame game, int maxHealth) {
        this.maxHealth = maxHealth;
        buildButtons(controller);
        buildProgressBar();
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
        buttonTable.add(buySmallUnit).size(100, 100).left().padBottom(10).padLeft(10);
        buttonTable.add(buyMediumUnit).size(100, 100).left().padBottom(10).padLeft(10);
        buttonTable.add(buyFastUnit).size(100, 100).left().padBottom(10).padLeft(10);
        buttonTable.add(buyHealUnit).size(100, 100).left().padBottom(10).padLeft(10);
        buttonTable.add(buyBigUnit).size(100, 100).left().padBottom(10).padLeft(10);
    }

    private void buildButtons(C_Game controller) {
        buySmallUnit = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("ui/buySmallUnitButton.png")))));
        buyFastUnit = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("ui/buyFastUnitButton.png")))));
        buyMediumUnit = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("ui/buyMediumUnitButton.png")))));
        buyBigUnit = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("ui/buyBigUnitButton.png")))));
        buyHealUnit = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("ui/buyHealUnitButton.png")))));
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
        buyHealUnit.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                controller.buyUnit(new M_HealUnit());
            }
        });
        quitGame.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.quitGame();
            }
        });
    }


    private void buildProgressBar() {
        Pixmap backgroundPixmap = new Pixmap(1, 20, Pixmap.Format.RGBA8888);
        backgroundPixmap.setColor(Color.NAVY);
        backgroundPixmap.fill();
        TextureRegionDrawable backgroundDrawable = new TextureRegionDrawable(new TextureRegion(new Texture(backgroundPixmap)));
        Pixmap fillingPixmap = new Pixmap(1, 20, Pixmap.Format.RGBA8888);
        fillingPixmap.setColor(new Color(1,0,1,1));
        fillingPixmap.fill();
        TextureRegionDrawable fillingDrawable = new TextureRegionDrawable(new TextureRegion(new Texture(fillingPixmap)));

        backgroundPixmap.dispose();
        fillingPixmap.dispose();

        ProgressBar.ProgressBarStyle style = new ProgressBar.ProgressBarStyle(backgroundDrawable, fillingDrawable);
        style.knobBefore = fillingDrawable;
        lifeBar = new ProgressBar(0.0f, maxHealth, 1.0f, false, style);
        lifeBar.setValue(maxHealth);
    }

    private void buildTopTable(C_Game controller) {
        createLabels();
        labelTable = new Table();
        labelTable.setBackground(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("ui/topBarBackground.png")))));
        labelTable.top().left();
        labelTable.defaults().uniformX().width(400);
        labelTable.setFillParent(true);
        labelTable.setFillParent(true);
        labelTable.add(worldTimer).padLeft(20);
        labelTable.add(resources);
        labelTable.add(buildHealthTable());
    }
    private Table buildHealthTable() {
        Table healthTable = new Table();
        healthTable.add(baseHealth);
        healthTable.add(lifeBar).padTop(5);
        healthTable.add(quitGame).padLeft(50);
        return healthTable;
    }

    BitmapFont createFont(FreeTypeFontGenerator ftfg, int dp) {
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = dp;
        return ftfg.generateFont(parameter);
    }
    //On Init

    private void createLabels() {
        BitmapFont font = createFont(new FreeTypeFontGenerator(Gdx.files.internal("font/arial.ttf")), 38);
        worldTimer = new Label(timerDesc + String.format("%5d", 0), new Label.LabelStyle(font, Color.GREEN));
        resources = new Label(resourceDesc + String.format("%5d", 50), new Label.LabelStyle(font, Color.GREEN));
        baseHealth = new Label(baseHealthDesc, new Label.LabelStyle(font, Color.GREEN));
    }

    public void update(int time, int balance, int health) {
        worldTimer.setText(timerDesc + String.format("%4d", time));
        resources.setText(resourceDesc + String.format("%5d", balance));
       lifeBar.setValue(health);
    }
}


