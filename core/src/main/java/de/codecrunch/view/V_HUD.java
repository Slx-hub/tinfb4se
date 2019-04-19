package de.codecrunch.view;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class V_HUD {
    public Stage stage;
    private Viewport viewport;
    private String test1 = "test";

    Label test;

    public V_HUD(SpriteBatch sb){
        viewport = new FitViewport(1024,576, new OrthographicCamera());
        stage = new Stage(viewport, sb);

        Table table = new Table();
        table.top();
        table.setFillParent(true);

        test = new Label(test1, new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        table.add(test).expandX().padTop(10);
        stage.addActor(table);
    }
}
