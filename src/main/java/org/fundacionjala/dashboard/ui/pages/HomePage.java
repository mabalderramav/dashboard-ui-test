package org.fundacionjala.dashboard.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.dashboard.ui.pages.menu.TopMenu;
import org.fundacionjala.dashboard.ui.pages.sidebar.SideBar;

/**
 * Class that display the main page of Mach2.
 */
public class HomePage extends AbstractBasePage {

    @FindBy(css = "a[data-action='show-main-menu']")
    private WebElement menuIcon;

    /**
     * Method that go to Top menu.
     *
     * @return The Top menu.
     */
    public TopMenu goToTopMenu() {
        return new TopMenu();
    }

    /**
     * Method that go to Sidebar.
     *
     * @return The Sidebar.
     */
    public SideBar goToSidebar() {
        menuIcon.click();
        return new SideBar();
    }

}
