package de.codecrunch.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;


public class V_HUD {

    private String levelName = ">Insert level name here<";
    private int timer;
    private int resources;
    private String timerDesc;
    private String resourceDesc;
    public TextButton button1;
    Table labelTable;
    Label level;
    Label timerDescLabel;
    Label resourceDescLabel;
    Label worldTimer;
    Label resourcesLabel;

    public V_HUD() {
        this.resources = 99999;
        this.timer = 99999;
        this.timerDesc = "timer";
        this.resourceDesc = "resources";

        this.labelTable = new Table();

        labelTable.top();
        labelTable.setFillParent(true);

        level = new Label(levelName, new Label.LabelStyle(new BitmapFont(), Color.GREEN));
        timerDescLabel = new Label(timerDesc, new Label.LabelStyle(new BitmapFont(), Color.GREEN));
        worldTimer = new Label(String.format("%05d", timer), new Label.LabelStyle(new BitmapFont(), Color.GREEN));
        resourceDescLabel = new Label(resourceDesc, new Label.LabelStyle(new BitmapFont(), Color.GREEN));
        resourcesLabel = new Label(String.format("%05d", resources), new Label.LabelStyle(new BitmapFont(), Color.GREEN));


        Skin buttonSkins = new Skin(Gdx.files.internal("skins/neon/neon-ui.json"));
         this.button1 = new TextButton("Place Tower", buttonSkins);
        labelTable.add(button1).expandX().left().padBottom(10);
        labelTable.add(level).expandX().padTop(10);
        labelTable.add(timerDescLabel).expandX().padTop(10);
        labelTable.add(resourceDescLabel).expandX().padTop(10);
        labelTable.row();
        labelTable.add(new Label("", new Label.LabelStyle(new BitmapFont(), Color.GREEN))).expandX().padTop(10);
        labelTable.add(worldTimer).expandX().padTop(10);
        labelTable.add(resourcesLabel).expandX().padTop(10);



    }

    public Table setUpHUD() {
        return labelTable;
    }

}
