package de.codecrunch.view;

import de.codecrunch.TowerAttackGame;
import de.codecrunch.controller.C_Settings;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

public class V_Settings extends VA_Screen {

    private C_Settings settings = new C_Settings();
    private Label titleLabel;
    private Label volumeMusicLabel;
    private Label volumeSoundLabel;
    private Label pushCheckboxLabel;

    public V_Settings(TowerAttackGame game) {
        super(game);
    }

    @Override
    public void show() {
        Table table = new Table();
        table.setFillParent(true);
        stage.addActor(table);

        TextButton save = new TextButton("Save", skin);

        final Slider volumeMusicSlider = new Slider(0f, 1f, 0.1f, false, skin);
        volumeMusicSlider.setValue(settings.getMusicVolume());
        volumeMusicSlider.addListener(event -> {
            settings.setMusicVolume(volumeMusicSlider.getValue());
            return false;
        });

        final Slider volumeSoundSlider = new Slider(0f, 1f, 0.1f, false, skin);
        volumeSoundSlider.setValue(settings.getSoundVolume());
        volumeSoundSlider.addListener(event -> {
            settings.setSoundVolume(volumeSoundSlider.getValue());
            return false;
        });

        final CheckBox pushCheckbox = new CheckBox(null, skin);
        pushCheckbox.setChecked(settings.isPushEnabled());
        pushCheckbox.addListener(event -> {
            boolean enabled = pushCheckbox.isChecked();
            settings.setPushEnabled(enabled);
            return false;
        });

        titleLabel = new Label("Settings", skin);
        volumeMusicLabel = new Label("Music", skin);
        volumeSoundLabel = new Label("Sound-Effects", skin);
        pushCheckboxLabel = new Label("Push-Notifications", skin);

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
        table.add(save).fillX().uniformX();


        save.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                towerAttackGame.changeScreen(TowerAttackGame.SCREENID_MENU);
            }
        });
    }
}
