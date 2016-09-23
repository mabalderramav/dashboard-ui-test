package org.fundacionjala.dashboard.ui.page;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractBasePage {

    @FindBy(css = "i.content.icon")
    WebElement menuIcon;

    public TopMenu goToTopMenu() {
        return new TopMenu();
    }


    public SideBar goToSidebar() {
        menuIcon.click();
        return new SideBar();
    }


//    public Dashboard goToDashboard() {
//        return new Dashboard();
//    }
}
