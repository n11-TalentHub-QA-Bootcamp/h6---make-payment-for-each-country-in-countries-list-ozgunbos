package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import tasks.LoginToEriBank;
import tasks.Logout;
import tasks.Payment;
import ui.HomePageElements;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;


public class PaymentSteps {
    @Managed(driver = "Appium")
    public WebDriver herMobileDevice;

    String actorName="ozgun";
    Actor actor = Actor.named(actorName);

    @Before
    public void set_the_stage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @When("user login")
    public void user_login() {
        actor.can(BrowseTheWeb.with(herMobileDevice));
        actor.attemptsTo(LoginToEriBank.login("company","company"));
    }

    @And("user make deposit via {string} {string} {string} {string}")
    public void userMakeDepositVia(String mobilPhone, String firstname, String amount,String user) {
        actor.attemptsTo(Payment.type(mobilPhone, firstname, amount,user));
    }

    @Then("user should check if it is ok or not")
    public void user_should_check() {
        actor.attemptsTo(
                Ensure.that(HomePageElements.BALANCE).attribute("content-desc").startsWith("Your balance")
        );
    }
    @And("user will logout from the app")
    public void userWillLogout() {
        actor.attemptsTo(Logout.logout());
    }

 
}


