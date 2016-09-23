package org.fundacionjala.dashboard.login;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.dashboard.ui.page.FavoritePage;

/**
 * Created by AlvaroDaza on 9/21/2016.
 */
public class FavoritePageSteps {

    private FavoritePage favoritePage;

    @Given("^Im in the favorite page$")
    public void im_in_the_favorite_page() {
       // LoginPage loginPage = new LoginPage();
     //   loginPage.setUsername("Alvaro.Daza@fundacion-jala.org");
      //  loginPage.setPasswordTextField("P@ssw0rd");
     //   loginPage.clickNextButton();
     // favoritePage = new FavoritePage();
    }

    @When("^I press in the dropdown list$")
    public void i_press_in_the_dropdown_list()  {
      favoritePage.clickOnTheUsernameDropDownListButton();
    }

    @And("^Select the option profile$")
    public void select_the_option_profile()  {
    favoritePage.clickOnOptionProfile();
    }

    @Then("^the profile page should displayed$")
    public void the_profile_page_should_displayed() {

    }



}
