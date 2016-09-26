package org.fundacionjala.dashboard.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.dashboard.ui.pages.menu.TopMenu;
import org.fundacionjala.dashboard.ui.pages.sidebar.SideBar;

public class HomePage extends AbstractBasePage {

    @FindBy(css = "a[data-action='show-main-menu']")
    private WebElement menuIcon;

    public TopMenu goToTopMenu() {
        return new TopMenu();
    }

    public SideBar goToSidebar() {
        menuIcon.click();
        return new SideBar();
    }

}
