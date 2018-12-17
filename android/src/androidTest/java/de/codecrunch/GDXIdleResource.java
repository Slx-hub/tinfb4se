package de.codecrunch;

import android.support.test.espresso.IdlingResource;

public class GDXIdleResource implements IdlingResource {
    private static int resourceCounter = 0;
    private ResourceCallback resourceCallback;
    private AndroidLauncher androidLauncher;

    @Override
    public String getName() {
        return "GDXIdleResource" + resourceCounter++;
    }

    @Override
    public boolean isIdleNow() {
        if (androidLauncher == null || androidLauncher.towerAttackGame == null)
            return false;
        else return true;
    }

    public GDXIdleResource setLauncher(AndroidLauncher launcher) {
        androidLauncher = launcher;
        return this;
    }

    @Override
    public void registerIdleTransitionCallback(ResourceCallback callback) {
        resourceCallback = callback;
    }
}
