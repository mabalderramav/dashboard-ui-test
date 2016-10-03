package org.fundacionjala.dashboard.cucumber.stepdefinition.profile;

import cucumber.api.java.en.And;

import org.fundacionjala.dashboard.ui.pages.menu.Profile;
import org.fundacionjala.dashboard.ui.pages.menu.Service;
import org.fundacionjala.dashboard.ui.pages.menu.TopMenu;

/**
 * Class to manage Step definition  for table widget of features.project.
 */
public class ServiceSteps {

    /**
     * Step definition to synchronize Mach2 and Pivotal Tracker applications.
     */
    @And("^Synchronize Mach2 and Pivotal$")
    public void synchronizeMach2AndPivotal() {
        TopMenu topMenu = new TopMenu();
        Profile profile = topMenu.clickOnProfileMenu();
        Service service = profile.clickSetting();
        service.setDescriptionTextField(String.valueOf(System.currentTimeMillis()));
        service.clickSaveButton();
        topMenu.clickJalasoftIcon();
    }
}
