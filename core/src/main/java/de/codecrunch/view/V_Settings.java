package de.codecrunch.view;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import de.codecrunch.TowerAttackGame;
import de.codecrunch.controller.C_Settings;

public class V_Settings extends VA_Screen {

    public TextButton save;

    private C_Settings settings = new C_Settings();
    private Label volumeMusicLabel;
    private Label volumeSoundLabel;
    private Label pushCheckboxLabel;

    public V_Settings(TowerAttackGame game) {
        super(game);
        Table table = new Table();
        table.setFillParent(true);
        stage.addActor(table);

        save = new TextButton("Save", uiSkin);

        final Slider volumeMusicSlider = new Slider(0f, 1f, 0.1f, false, uiSkin);
        volumeMusicSlider.setValue(settings.getMusicVolume());
        volumeMusicSlider.addListener(event -> {
            settings.setMusicVolume(volumeMusicSlider.getValue());
            return false;
        });

        final Slider volumeSoundSlider = new Slider(0f, 1f, 0.1f, false, uiSkin);
        volumeSoundSlider.setValue(settings.getSoundVolume());
        volumeSoundSlider.addListener(event -> {
            settings.setSoundVolume(volumeSoundSlider.getValue());
            return false;
        });

        final CheckBox pushCheckbox = new CheckBox(null, uiSkin);
        pushCheckbox.setChecked(settings.isPushEnabled());
        pushCheckbox.addListener(event -> {
            boolean enabled = pushCheckbox.isChecked();
            settings.setPushEnabled(enabled);
            return false;
        });

        volumeMusicLabel = new Label("Music", uiSkin);
        volumeSoundLabel = new Label("Sound-Effects", uiSkin);
        pushCheckboxLabel = new Label("Push-Notifications", uiSkin);

        table.add(volumeMusicSlider).fillX().uniformX();
        table.add(volumeMusicLabel);
        table.row();
        table.add(volumeSoundSlider).fillX().uniformX();
        table.add(volumeSoundLabel);
        table.row();
        table.add(pushCheckbox).fillX().uniformX();
        table.add(pushCheckboxLabel);
        table.row();
        table.add(save).colspan(2);


        save.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                towerAttackGame.changeScreen(TowerAttackGame.SCREENID_MENU);
            }
        });
    }

    @Override
    public void show() {
        // Empty on purpose
    }
}
