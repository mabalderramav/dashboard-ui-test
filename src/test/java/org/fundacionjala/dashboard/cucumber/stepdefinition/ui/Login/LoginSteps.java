package org.fundacionjala.dashboard.cucumber.stepdefinition.ui.Login;

import java.util.Map;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.fundacionjala.dashboard.ui.pages.HomePage;
import org.fundacionjala.dashboard.ui.pages.LoginPage;
import org.fundacionjala.dashboard.ui.pages.menu.TopMenu;

import static org.fundacionjala.dashboard.cucumber.hooks.AssertionHooks.getAssertion;


/**
 * Class to manage the step definition for Login to Mach2 page.
 */
public class LoginSteps {
    private HomePage homePage;
    private TopMenu topMenu;

    /**
     * Step definition to perform a login as a user to Mach2 application.
     *
     * @param userData Data of the user to perform a login to Mach2 application.
     */
    @When("^I perform a login as$")
    public void iPerformALoginAs(final Map<String, Object> userData) {
        homePage = LoginPage.loginOtherUser(String.valueOf(userData.get("userName")),
                String.valueOf(userData.get("password")));
        topMenu = homePage.goToTopMenu();
    }

    /**
     * Step definition to validate if the user has been logged.
     */
    @Then("^I will have a user logged$")
    public void iWillBeInTheHomepage() {
        topMenu = homePage.goToTopMenu();
        getAssertion().assertTrue(topMenu.isUserMenuPresent());
    }
}
