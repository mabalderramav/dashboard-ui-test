package org.fundacionjala.dashboard.ui.page;

/**
 * Created by AlvaroDaza on 9/23/2016.
 */
public class ServicePage {
    private final TopMenu topMenu;

    public ServicePage(){
        topMenu = new TopMenu();
    }

    public void clickOnDropDownList() {
        topMenu.clickOnDropDownList();
    }

    public void clickOnProfile() {
        topMenu.clickOnProfile();
    }
}
