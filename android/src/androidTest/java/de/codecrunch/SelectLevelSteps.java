package de.codecrunch;

import org.junit.Rule;
import android.support.test.rule.ActivityTestRule;
import de.codecrunch.AndroidLauncher;
import com.mauriciotogneri.greencoffee.GreenCoffeeSteps;

//uncomment for running tests, comment for autocorrection in .feature files

import com.mauriciotogneri.greencoffee.annotations.And;
import com.mauriciotogneri.greencoffee.annotations.Given;
import com.mauriciotogneri.greencoffee.annotations.Then;
import com.mauriciotogneri.greencoffee.annotations.When;


//comment for running tests, uncomment for autocorrection in .feature files
/*
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
*/

class SelectLevelSteps extends CoreSteps{

    // "is" or "is not"
    private String solved;
    // "am" or "am not"
    private String toBe;
    // "top" or "bottom"
    private String position;
    // "next higher" or next lower" or "same"
    private String direction;

    @Rule
    public final ActivityTestRule<AndroidLauncher> main = new ActivityTestRule<>(AndroidLauncher.class);

    @When("^I click on the level I want to play$")
    public void iClickOnTheLevelIWantToPlay() throws Throwable {
        // Write code here that turns the phrase above into concrete actions



        throw new Exception("case not specified");
    }

    @And("^The previous level \"([^\"]*)\" solved or first level$")
    public void thePreviousLevelSolvedOrFirstLevel(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        solved = arg0;

        throw new Exception("case not specified");
    }

    @Then("^I the selected level should start$")
    public void iTheSelectedLevelShouldStart() throws Throwable {
        // Write code here that turns the phrase above into concrete actions



        throw new Exception("case not specified");
    }

    @And("^I \"([^\"]*)\" at the \"([^\"]*)\" of the List$")
    public void iAtTheOfTheList(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        toBe = arg0;
        position = arg1;

        throw new Exception("case not specified");
    }

    @And("^I get to see the \"([^\"]*)\" levels$")
    public void iGetToSeeTheLevels(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        direction = arg0;

        throw new Exception("case not specified");
    }
}
