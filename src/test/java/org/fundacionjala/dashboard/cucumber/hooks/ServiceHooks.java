package org.fundacionjala.dashboard.cucumber.hooks;

import cucumber.api.java.Before;
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
    private static final int EXECUTION_ORDER_FIVE = 5;
    private static final int EXECUTION_ORDER_THREE = 3;

    /**
     * This Method to add a Pivotal service as by default.
     */
    @Before(value = "@addPivotalTrackerService", order = EXECUTION_ORDER_FIVE)
    public void addPivotalService() {
        HomePage homePage = new HomePage();
        TopMenu topMenu = homePage.goToTopMenu();
        Map<ServiceFieldStep, String> serviceMapByDefault = new HashMap<>();
        Profile profile = topMenu.clickOnProfileMenu();
        Service service = profile.clickAddServiceButton();
        service.selectServiceDropdown(PIVOTAL_TRACKER_SERVICE_NAME);
        service.setDescriptionTextField(DESCRIPTION);
        service.setTokenTextField(Environment.getInstance().getToken());
        service.clickSaveButton();
        topMenu.clickJalasoftIcon();

    }

    /**
     * This method delete all services that there is registered into mach2.
     */
    @Before(value = "@deleteAllServices", order = EXECUTION_ORDER_THREE)
    public void deleteAllservices() {
        HomePage homePage = new HomePage();
        TopMenu topMenu = homePage.goToTopMenu();
        Profile profile = topMenu.clickOnProfileMenu();
        profile.deleteAllServices();
        topMenu.clickJalasoftIcon();
    }

}
