package de.codecrunch;

import android.support.test.rule.ActivityTestRule;

import com.mauriciotogneri.greencoffee.GreenCoffeeConfig;
import com.mauriciotogneri.greencoffee.GreenCoffeeTest;
import com.mauriciotogneri.greencoffee.ScenarioConfig;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;

import de.codecrunch.AndroidLauncher;

@RunWith(Parameterized.class)
public class CoreTests extends GreenCoffeeTest
{
    @Rule
    public ActivityTestRule activity = new ActivityTestRule<>(AndroidLauncher.class);

    public CoreTests(ScenarioConfig scenarioConfig)
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

    @Test
    public void test()
    {
        start(new CoreSteps());
    }
}