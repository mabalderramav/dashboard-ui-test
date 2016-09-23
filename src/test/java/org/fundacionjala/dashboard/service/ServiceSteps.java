package org.fundacionjala.dashboard.service;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.dashboard.ui.page.Profile;
import org.fundacionjala.dashboard.ui.page.ServicePage;
import org.fundacionjala.dashboard.utility.Environment;

/**
 * Created by AlvaroDaza on 9/22/2016.
 */
public class ServiceSteps {
    private final ServicePage servicePage;
    private final Profile profile;
    private final Environment ENVIROMENT= Environment.getInstance();

    public ServiceSteps(){
        servicePage = new ServicePage();
        profile = new Profile();
    }

    @Given("^I want to add a service$")
    public void iWantToAddAService() {

    }

    @When("^I click  on the user dropdown list$")
    public void iClickOnTheUserDropdownList()  {
       servicePage.clickOnDropDownList();
    }

    @When("^Select the profile option$")
    public void selectTheProfileOption(){
      servicePage.clickOnProfile();
    }
    @When("^Click add service button$")
    public void clickAddServiceButton(){
       profile.clickAddServiceButton();
    }
    @When("^Click On dropdown List of services$")
    public void clickOnDropDownListOfServices(){
        profile.clickDropDownList();
    }
    @When("^Select the pivotal tracker option$")
    public void selectThePivotalTrackerOption(){
        profile.clickPivotalTrackerItem();
    }

    @When("^Insert the information required$")
    public void insertTheInformationRequired(){
        profile.insertTheInformationRequired(ENVIROMENT.getToken());
    }
    @When("^Click on save Services$")
    public void clickOnSaveServices(){
        profile.clickSaveServices();
    }
    @Then("^the profile page is displayed$")
    public void theProfilePageIsDisplayed(){

    }
}
