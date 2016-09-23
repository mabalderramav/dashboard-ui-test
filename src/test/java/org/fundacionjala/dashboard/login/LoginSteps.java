package org.fundacionjala.dashboard.login;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.dashboard.ui.page.LoginPage;
import org.fundacionjala.dashboard.utility.Environment;

/**
 * Created by AlvaroDaza on 9/21/2016.
 */
public class LoginSteps {

    private final LoginPage loginPage;
    private static final Environment ENVIRONMENT = Environment.getInstance();

    public LoginSteps() {
        loginPage = new LoginPage();
    }

    @When("^I send my login data$")
    public void iSendMyLoginData() {
        loginPage.setUsername(ENVIRONMENT.getUser());
        loginPage.setPasswordTextField(ENVIRONMENT.getPassword());
    }

    @Then("^The favorites page is displayed$")
    public void theFavoritesPageIsDisplayed() {
        loginPage.clickNextButton();

    }

    @And("^I logout of the page$")
    public void iLogoutOfThePage() {
        loginPage.clickOnLogOut();
    }
}
