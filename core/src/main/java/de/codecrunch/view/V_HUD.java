package de.codecrunch.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
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
    private int timeCount = 0;
    private ImageButton button;
    Label level;
    Label timerDescLabel;
    Label resourceDescLabel;
    Label worldTimer;
    Label resourcesLabel;

    TextureAtlas buttonAtlas;

    ImageButton turretPlacer;

    public V_HUD(SpriteBatch sb) {
        this.resources = 99999;
        this.timer = 99999;
        this.timerDesc = "timer";
        this.resourceDesc = "resources";
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

        Gdx.input.setInputProcessor(stage);
        Skin buttonSkins = new Skin(Gdx.files.internal("skins/neon/neon-ui.json"));
        TextButton button1 = new TextButton("Place Tower", buttonSkins);
       /* button1.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if(button1.isChecked()) {
                    button1.setChecked(false);
                    button1.setText("placed Tower");
                    System.out.println("false");
                }
                else {
                    button1.setChecked(true);
                    button1.setText("place Tower");
                }
            }
        });*/
        buttonTable.add(button1).expandX().left().padBottom(10);
        labelTable.add(level).expandX().padTop(10);
        labelTable.add(timerDescLabel).expandX().padTop(10);
        labelTable.add(resourceDescLabel).expandX().padTop(10);
        labelTable.row();
        labelTable.add(new Label("", new Label.LabelStyle(new BitmapFont(), Color.GREEN))).expandX().padTop(10);
        labelTable.add(worldTimer).expandX().padTop(10);
        labelTable.add(resourcesLabel).expandX().padTop(10);

        stage.addActor(button1);
        stage.addActor(labelTable);
        stage.addActor(buttonTable);
    }

}
