package de.codecrunch.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class V_HUD {
    public Stage stage;
    private Viewport viewport;
    private String levelName = ">Insert level name here<";
    private int timer;
    private int resources;
    private String timerDesc;
    private String resourceDesc;

    Label level;
    Label timerDescLabel;
    Label resourceDescLabel;
    Label worldTimer;
    Label resourcesLabel;

    ImageButton turretPlacer;

    public V_HUD(SpriteBatch sb) {
        this.resources = 99999;
        this.timer = 99999;
        this.timerDesc = "timer: ";
        this.resourceDesc = "resources: ";
        viewport = new FitViewport(1024, 576, new OrthographicCamera());
        stage = new Stage(viewport, sb);
        Table labelTable = new Table();
        Table buttonTable = new Table();

        labelTable.top();
        labelTable.setFillParent(true);
        buttonTable.bottom();
        buttonTable.setFillParent(true);

        level = new Label(levelName, new Label.LabelStyle(new BitmapFont(), Color.GREEN));
        timerDescLabel = new Label(timerDesc, new Label.LabelStyle(new BitmapFont(), Color.GREEN));
        worldTimer = new Label(String.format("%05d", timer), new Label.LabelStyle(new BitmapFont(), Color.GREEN));
        resourceDescLabel = new Label(resourceDesc, new Label.LabelStyle(new BitmapFont(), Color.GREEN));
        resourcesLabel = new Label(String.format("%05d", resources), new Label.LabelStyle(new BitmapFont(), Color.GREEN));

        Texture turretUp = new Texture(Gdx.files.internal("turretUp.png"));
        Texture turretDown = new Texture(Gdx.files.internal("turretDown.png"));
        TextureRegion textureRegionTurretUp = new TextureRegion(turretUp);
        TextureRegion textureRegionTurretDown = new TextureRegion(turretDown);
        TextureRegionDrawable texRegionDrawableTurretUp = new TextureRegionDrawable(textureRegionTurretUp);
        TextureRegionDrawable texRegionDrawableTurretDown = new TextureRegionDrawable(textureRegionTurretDown);
        ImageButton button = new ImageButton(texRegionDrawableTurretUp, texRegionDrawableTurretDown); //Set the button up

        Gdx.input.setInputProcessor(stage);
        stage.act(Gdx.graphics.getDeltaTime());
        buttonTable.add(button).expandX().left().padBottom(10);
        labelTable.add(level).expandX().left().padLeft(10).padTop(10);
        labelTable.add(timerDescLabel).padTop(10);
        labelTable.add(worldTimer).padTop(10);
        labelTable.add(resourcesLabel).expandX().right().padTop(10).padRight(10);

        stage.addActor(labelTable);
        stage.addActor(buttonTable);
    }
}
