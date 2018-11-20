package de.codecrunch.view;

import de.codecrunch.TowerAttackGame;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

public class V_Settings extends VA_Screen {

    private TowerAttackGame game;
    private Label titleLabel;
    private Label volumeMusicLabel;
    private Label volumeSoundLabel;
    private Label pushCheckboxLabel;

    public V_Settings(TowerAttackGame game) {
        super(game);
        this.game = game;
    }

    @Override
    public void show() {
        Table table = new Table();
        table.setFillParent(true);
        stage.addActor(table);

        TextButton back = new TextButton("Back", skin);

        final Slider volumeMusicSlider = new Slider( 0f, 1f, 0.1f,false, skin );
        //volumeMusicSlider.setValue( game.getPreferences().getMusicVolume() );
        volumeMusicSlider.addListener( new EventListener() {
            @Override
            public boolean handle(Event event) {
                //game.getPreferences().setMusicVolume( volumeMusicSlider.getValue() );
                return false;
            }
        });

        final Slider volumeSoundSlider = new Slider( 0f, 1f, 0.1f,false, skin );
        //volumeSoundSlider.setValue( game.getPreferences().getMusicVolume() );
        volumeSoundSlider.addListener( new EventListener() {
            @Override
            public boolean handle(Event event) {
                //game.getPreferences().setMusicVolume( volumeSoundSlider.getValue() );
                return false;
            }
        });

        final CheckBox pushCheckbox = new CheckBox(null, skin);
        //pushCheckbox.setChecked( game.getPreferences().isMusicEnabled() );
        pushCheckbox.addListener( new EventListener() {
            @Override
            public boolean handle(Event event) {
                boolean enabled = pushCheckbox.isChecked();
                //game.getPreferences().setMusicEnabled( enabled );
                return false;
            }
        });

        //private Box2DTutorial parent;
        //private Stage stage;
        // our new fields


        titleLabel = new Label( "Settings", skin );
        volumeMusicLabel = new Label( "Music", skin );
        volumeSoundLabel = new Label( "Sound-Effects", skin );
        pushCheckboxLabel = new Label( "Push-Notifications", skin );

        //table.add(titleLabel);
        //table.row();
        //table.add(volumeMusicSlider);
        table.add(volumeMusicSlider).fillX().uniformX();
        table.row();
        table.row();
        table.add(volumeMusicLabel);
        table.row();
        table.add(volumeSoundSlider).fillX().uniformX();
        table.row();
        table.row();
        table.add(volumeSoundLabel);
        table.row();
        table.add(pushCheckbox);
        table.add(pushCheckboxLabel);
        table.row();
        table.add(back).fillX().uniformX();


        back.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.changeScreen(towerAttackGame. MENUID);
            }
        });
    }
}
