package org.fundacionjala.dashboard.login;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.dashboard.ui.page.LoginPage;

/**
 * Created by AlvaroDaza on 9/21/2016.
 */
public class LoginSteps {
    LoginPage loginPage = new LoginPage();

    @When("^I send my password and username$")
    public void i_send_my_password_and_username() {
        loginPage.setUsername("Alvaro.Daza@fundacion-jala.org");
        loginPage.setPasswordTextField("P@ssw0rd");
    }

    @Then("^The favorites page is displayed$")
    public void the_favorites_page_is_displayed() {
        loginPage.clickNextButton();

    }

    @And("^I logout$")
    public void i_logout() {

    }
}
