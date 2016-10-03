package org.fundacionjala.dashboard.cucumber.stepdefinition.Login;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.dashboard.ui.pages.HomePage;
import org.fundacionjala.dashboard.ui.pages.LoginPage;

/**
 * Class to manage the step definition for Login to Mach2 page
 */

public class LoginSteps {

    @When("^I perform a login to (.*)$")
    public void iPerformALoginToMach(){
        HomePage homePage = LoginPage.loginAsSecondaryUser();
    }

    @Then("^I will have a session started$")
    public void iWillBeInTheHomepage() {
        LoginPage loginPage = new LoginPage();
//        loginPage.isUserLogged();

    }
}
