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

class AlterSettingsSteps extends CoreSteps{

    // "music" or "sound-effects"
    private String volumeType;
    // "is" or "is not"
    private String status;
    // "min" or "max"
    private String position;
    // "right" or "left"
    private String direction;
    // "increase" or "decrease"
    private String action;
    // "move" or "not move" - Slidermovement
    private String movement;
    // "enabled" or "disabled"
    private String push;
    // "checked" or "unchecked"
    private String check;


    @Rule
    public final ActivityTestRule<AndroidLauncher> main = new ActivityTestRule<>(AndroidLauncher.class);
    
    @And("^The \"([^\"]*)\" volume \"([^\"]*)\" at \"([^\"]*)\"$")
    public void theVolumeAt(String arg0, String arg1, String arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        volumeType = arg0;
        status = arg1;
        position = arg2;

        throw new Exception("case not specified");
    }

    @When("^I drag the \"([^\"]*)\" volume slider to the \"([^\"]*)\"$")
    public void iDragTheVolumeSliderToThe(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        volumeType = arg0;
        direction = arg0;

        throw new Exception("case not specified");
    }

    @Then("^The \"([^\"]*)\" volume should \"([^\"]*)\"$")
    public void theVolumeShould(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        volumeType = arg0;
        action = arg1;

        throw new Exception("case not specified");
    }

    @And("^The \"([^\"]*)\" volume slider should \"([^\"]*)\" \"([^\"]*)\"$")
    public void theVolumeSliderShould(String arg0, String arg1, String arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        volumeType = arg0;
        movement = arg1;
        if ( arg2 != "" ) direction = arg2;

        throw new Exception("case not specified");
    }

    @And("^Push-Notifications are \"([^\"]*)\"$")
    public void pushNotificationsAre(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        push = arg0;

        throw new Exception("case not specified");
    }

    @And("^The check-box is \"([^\"]*)\"$")
    public void theCheckBoxIs(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        check = arg0;

        throw new Exception("case not specified");
    }
}
