package steps;

//import de.codecrunch.<alterSettingsActivity>

//import org.junit.Rule; //does not exist??
//import android.support.test.rule.ActivityTestRule; // does not exist??
import com.mauriciotogneri.greencoffee.GreenCoffeeSteps;

import java.sql.Driver;

//import cucumber.api.PendingException;  // does not exist??

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

class CoreSteps {

    @Given("^I \"([^\"]*)\" on the \"([^\"]*)\" screen$")
    public void iOnTheScreen(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String action = arg0;
        String screenName = arg1;



        //throw new PendingException();
    }

    @When("^I click on the \"([^\"]*)\" button$")
    public void iClickOnTheButton(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String buttonName = arg0;

        //throw new PendingException();
    }

    @Then("^I should see the \"([^\"]*)\" message$")
    public void iShouldSeeTheMessage(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String messageText = arg0;

        //throw new PendingException();
    }
}
