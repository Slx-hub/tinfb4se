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


class CoreSteps extends GreenCoffeeSteps{

    @Rule
    public ActivityTestRule<AndroidLauncher> mActivityTestRule = new ActivityTestRule<>(AndroidLauncher.class);

    @Given("^I \"([^\"]*)\" on the \"([^\"]*)\" screen$")
    public void iOnTheScreen(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String action = arg0;
        String screenName = arg1;



        throw new Exception("case not specified");
    }

    @When("^I click on the \"([^\"]*)\" button$")
    public void iClickOnTheButton(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String buttonName = arg0;

        throw new Exception("case not specified");
    }

    @Then("^I should see the \"([^\"]*)\" message$")
    public void iShouldSeeTheMessage(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String messageText = arg0;

        throw new Exception("case not specified");
    }
}
