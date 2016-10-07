package org.fundacionjala.dashboard.cucumber.hooks;

import cucumber.api.java.Before;
import org.fundacionjala.dashboard.handler.ServiceHandler;
import org.fundacionjala.dashboard.ui.pages.HomePage;
import org.fundacionjala.dashboard.ui.pages.menu.Profile;
import org.fundacionjala.dashboard.ui.pages.menu.Service;
import org.fundacionjala.dashboard.ui.pages.menu.ServiceFieldStep;
import org.fundacionjala.dashboard.ui.pages.menu.TopMenu;
import org.fundacionjala.dashboard.utils.Environment;

import java.util.HashMap;
import java.util.Map;


/**
 * This class add a service by default(PivotalTracker).
 */
public class ServiceHooks {
    private static final String PIVOTAL_TRACKER_SERVICE_NAME = "Pivotal Tracker";
    private static final String DESCRIPTION = "AT01-PivotalTracker";

    /**
     * This Method to add a Pivotal service as by default.
     */
    @Before("@addPivotalTrackerService")
    public void addPivotalService() {
        HomePage homePage = new HomePage();
        TopMenu topMenu = homePage.goToTopMenu();
        Map<ServiceFieldStep, String> serviceMapByDefault = new HashMap<>();
        serviceMapByDefault.put(ServiceFieldStep.TOKEN, Environment.getInstance().getToken());
        ServiceHandler serviceHandler = ServiceHandler.getInstance();
        if (!serviceHandler.exist(serviceMapByDefault)) {
            serviceHandler.addService(serviceMapByDefault);
            Profile profile = topMenu.clickOnProfileMenu();
            Service service = profile.clickAddServiceButton();
            service.selectServiceDropdown(PIVOTAL_TRACKER_SERVICE_NAME);
            service.setDescriptionTextField(DESCRIPTION);
            service.setTokenTextField(Environment.getInstance().getToken());
            service.clickSaveButton();
            topMenu.clickJalasoftIcon();
        }
    }

    /**
     * This method delete all services that there is registered into mach2.
     */
    @Before("@deleteAllServices")
    public void deleteAllservices() {
        HomePage homePage = new HomePage();
        TopMenu topMenu = homePage.goToTopMenu();
        Profile profile = topMenu.clickOnProfileMenu();
        profile.deleteAllServices();
    }

}
