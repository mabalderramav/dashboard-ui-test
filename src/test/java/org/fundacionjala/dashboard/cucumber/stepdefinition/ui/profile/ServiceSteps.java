package org.fundacionjala.dashboard.cucumber.stepdefinition.ui.profile;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.fundacionjala.dashboard.ui.pages.menu.Profile;
import org.fundacionjala.dashboard.ui.pages.menu.Service;
import org.fundacionjala.dashboard.ui.pages.menu.ServiceFieldStep;
import org.fundacionjala.dashboard.ui.pages.menu.Steps;
import org.fundacionjala.dashboard.ui.pages.menu.TopMenu;

import java.util.Map;
import java.util.Set;

/**
 * Class to manage the services steps.
 */
public class ServiceSteps {

    /**
     * The method add a service to Mach2.
     *
     * @param serviceMap String map with the with the steps.
     */
    @When("^I add a service$")
    public void iAddAService(final Map<ServiceFieldStep, String> serviceMap) {
        TopMenu topmenu = new TopMenu();
        Profile profile = topmenu.clickOnProfileMenu();
        Service service = profile.clickAddServiceButton();
        Map<ServiceFieldStep, Steps> strategyMap = service.getServiceFieldStepsMap(serviceMap);
        Set<ServiceFieldStep> keys = serviceMap.keySet();
        for (ServiceFieldStep key : keys) {
            strategyMap.get(key).executeStep();
        }
        service.clickSaveButton();
    }

    /**
     * This method updated to a specific service and project.
     *
     * @param serviceType String, service's type.
     * @param projectType String, project's type.
     */
    @And("^Synchronize Mach2 with (.*) and project (.*)$")
    public void synchronizeMach2AndPivotal(final String serviceType, final String projectType) {
        TopMenu topMenu = new TopMenu();
        Profile profile = topMenu.clickOnProfileMenu();
        Service service = profile.clickSetting();
        service.setDescriptionTextField(String.valueOf(System.currentTimeMillis()));
        service.clickSaveButton();
        topMenu.clickJalasoftIcon();
    }

}
