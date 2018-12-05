package de.codecrunch;


import android.support.test.espresso.NoActivityResumedException;
import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;

import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static junit.framework.TestCase.fail;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class AndroidLauncherTest_ExitApp {

    @Rule
    public ActivityTestRule<AndroidLauncher> mActivityTestRule = new ActivityTestRule<>(AndroidLauncher.class);

    @Test
    public void androidLauncherTest_ExitApp() {
        try {
            pressBack();
            fail("Should have thrown NoActivityResumedException");
        } catch (NoActivityResumedException expected) {
        }
    }
}
