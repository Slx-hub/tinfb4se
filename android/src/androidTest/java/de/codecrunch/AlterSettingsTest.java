package de.codecrunch;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.IdlingRegistry;
import android.support.test.rule.ActivityTestRule;

import com.mauriciotogneri.greencoffee.GreenCoffeeConfig;
import com.mauriciotogneri.greencoffee.GreenCoffeeTest;
import com.mauriciotogneri.greencoffee.ScenarioConfig;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;

@RunWith(Parameterized.class)
public class AlterSettingsTest extends GreenCoffeeTest{

    @Rule
    public ActivityTestRule<AndroidLauncher> activity = new ActivityTestRule<>(AndroidLauncher.class);

    public AlterSettingsTest(ScenarioConfig scenarioConfig)
    {
        super(scenarioConfig);
    }

    @Parameterized.Parameters(name = "{0}")
    public static Iterable scenarios() throws IOException
    {
        return new GreenCoffeeConfig()
                .withFeatureFromAssets("assets/alterSettings.feature")
                .scenarios(
                        //new Locale("en", "GB")
                ); // the locales used to run the scenarios (optional)
    }

    // Register your Idling Resource before any tests regarding this component
    @Before
    public void registerIdlingResource() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getIdlingResource());
    }

    // Unregister your Idling Resource so it can be garbage collected and does not leak any memory
    @After
    public void unregisterIdlingResource() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getIdlingResource());
    }

    @Test
    public void test()
    {
        //don't this this is still needed:
        //IdlingRegistry.getInstance().register(new GDXIdleResource(100000).setLauncher(activity.getActivity()));
        start(new AlterSettingsSteps());
    }
}
