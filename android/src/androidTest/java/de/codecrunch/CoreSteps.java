package de.codecrunch;

import android.support.design.widget.TextInputLayout;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.contrib.DrawerActions;
import android.support.test.espresso.contrib.NavigationViewActions;
import android.support.test.rule.ActivityTestRule;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

import de.codecrunch.AndroidLauncher;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.mauriciotogneri.greencoffee.GreenCoffeeSteps;

import com.mauriciotogneri.greencoffee.annotations.And;
import com.mauriciotogneri.greencoffee.annotations.Given;
import com.mauriciotogneri.greencoffee.annotations.Then;
import com.mauriciotogneri.greencoffee.annotations.When;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;

import de.codecrunch.AndroidLauncher;
import de.codecrunch.view.V_EditorLevelSelect;
import de.codecrunch.view.V_Menu;
import de.codecrunch.view.V_Settings;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.DrawerMatchers.isClosed;
import static android.support.test.espresso.matcher.ViewMatchers.hasErrorText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.isA;


//import cucumber.api.java.en.And;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;


class CoreSteps extends GreenCoffeeSteps {

    @Rule
    public ActivityTestRule<AndroidLauncher> mActivityTestRule = new ActivityTestRule<>(AndroidLauncher.class);

    @Given("^I \"([^\"]*)\" on the \"([^\"]*)\" screen$")
    public void iOnTheScreen(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String action = arg0; // atm possible values: "am" & "get" & "stay"
        String screenName = arg1; // atm possible values: "settings" & "menu" & "selectLevel"

        TowerAttackGame game = mActivityTestRule.getActivity().towerAttackGame;
        Screen current = game.getScreen();

        switch (screenName) {
            case "settings":
                if (action.equals("am") || action.equals("stay")) {
                    if (!(current instanceof V_Settings))
                        throw new Exception("App not in screen " + screenName);
                } else if (action.equals("get"))
                    game.changeScreen(TowerAttackGame.SCREENID_SETTINGS);
                break;
            case "menu":
                if (action.equals("am") || action.equals("stay")) {
                    if (!(current instanceof V_Menu))
                        throw new Exception("App not in screen " + screenName);
                } else if (action.equals("get"))
                    game.changeScreen(TowerAttackGame.SCREENID_MENU);
                break;
            case "selectLevel":
                if (action.equals("am") || action.equals("stay")) {
                    if (!(current instanceof V_Settings))
                        throw new Exception("App not in screen " + screenName);
                } else if (action.equals("get"))
                    game.changeScreen(TowerAttackGame.SCREENID_EDITORLVLSELECT);
                break;
            default:
                throw new Exception("Screen " + screenName + " is not a valid screen.");
        }


    }

    @When("^I click on the \"([^\"]*)\" button$")
    public void iClickOnTheButton(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String buttonName = arg0;

        TowerAttackGame game = mActivityTestRule.getActivity().towerAttackGame;
        Screen current = game.getScreen();

        switch (buttonName) {
            case "save":
                V_Settings settings = (V_Settings) current;
                ((ChangeListener) settings.save.getListeners().get(0)).changed(null, null);
                break;
            default:
                break;
        }

        throw new Exception("case not specified");
    }

    @Then("^I should see the \"([^\"]*)\" message$")
    public void iShouldSeeTheMessage(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String messageText = arg0;

        throw new Exception("case not specified");
    }
}
