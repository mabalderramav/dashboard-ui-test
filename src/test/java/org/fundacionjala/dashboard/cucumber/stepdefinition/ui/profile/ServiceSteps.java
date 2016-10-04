package org.fundacionjala.dashboard.cucumber.stepdefinition.ui.profile;

import cucumber.api.java.en.And;

import org.fundacionjala.dashboard.ui.pages.menu.Profile;
import org.fundacionjala.dashboard.ui.pages.menu.Service;
import org.fundacionjala.dashboard.ui.pages.menu.TopMenu;

/**
 * Class to manage Step definition  for table widget of features.project.
 */
public class ServiceSteps {

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
