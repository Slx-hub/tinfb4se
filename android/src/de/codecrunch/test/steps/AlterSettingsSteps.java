package steps;

//import de.codecrunch.<alterSettingsActivity>

import org.junit.Rule;
import android.support.test.rule.ActivityTestRule;

import com.mauriciotogneri.greencoffee.GreenCoffeeSteps;

//uncomment for running tests, comment for autocorrection in .feature files
//import com.mauriciotogneri.greencoffee.annotations.And;
//import com.mauriciotogneri.greencoffee.annotations.Given;
//import com.mauriciotogneri.greencoffee.annotations.Then;
//import com.mauriciotogneri.greencoffee.annotations.When;

//comment for running tests, uncomment for autocorrection in .feature files
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


class AlterSettingsSteps {
    @Rule
    public final ActivityTestRule<settingsActivity> main = new ActivityTestRule<>(settingsActivity.class);
    
    @And("^The \"([^\"]*)\" volume \"([^\"]*)\" at \"([^\"]*)\"$")
    public void theVolumeAt(String arg0, String arg1, String arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }


    @When("^I drag the \"([^\"]*)\" volume slider to the \"([^\"]*)\"$")
    public void iDragTheVolumeSliderToThe(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^The \"([^\"]*)\" volume should \"([^\"]*)\"$")
    public void theVolumeShould(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^The \"([^\"]*)\" volume slider should \"([^\"]*)\" \"([^\"]*)\"$")
    public void theVolumeSliderShould(String arg0, String arg1, String arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^Push-Notifications are \"([^\"]*)\"$")
    public void pushNotificationsAre(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^The check-box is \"([^\"]*)\"$")
    public void theCheckBoxIs(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
