package de.codecrunch.controller;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;


public class C_Settings {
    private static final String PREF_MUSIC_VOLUME = "volume";
    private static final String PREF_PUSH_ENABLED = "push.enabled";
    private static final String PREF_SOUND_VOL = "sound";
    private static final String PREFS_NAME = "code_crunch.tower_attack";


    protected Preferences getPrefs() {
        return Gdx.app.getPreferences(PREFS_NAME);
    }

    public boolean isPushEnabled() {
        return getPrefs().getBoolean(PREF_PUSH_ENABLED, true);
    }

    public void setPushEnabled(boolean pushEnabled) {

        getPrefs().putBoolean(PREF_PUSH_ENABLED, pushEnabled);
        getPrefs().flush();
    }

    public float getMusicVolume() {

        return getPrefs().getFloat(PREF_MUSIC_VOLUME, 0.5f);
    }

    public void setMusicVolume(float volume) {
        getPrefs().putFloat(PREF_MUSIC_VOLUME, volume);
        getPrefs().flush();
    }

    public float getSoundVolume() {
        return getPrefs().getFloat(PREF_SOUND_VOL, 0.5f);
    }

    public void setSoundVolume(float volume) {
        getPrefs().putFloat(PREF_SOUND_VOL, volume);
        getPrefs().flush();
    }
}
