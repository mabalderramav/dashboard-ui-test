package org.fundacionjala.dashboard.ui.pages.menu;

import org.fundacionjala.dashboard.ui.pages.AbstractBasePage;
import org.fundacionjala.dashboard.ui.pages.LoginPage;
import org.fundacionjala.dashboard.ui.pages.content.BoardPage;
import org.fundacionjala.dashboard.ui.pages.sidebar.SideBar;
import org.fundacionjala.dashboard.utils.Environment;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

/**
 * Class to manage the Top menu of Mach2.
 */
public class TopMenu extends AbstractBasePage {

    public static final int DURATION = 3;

    @FindBy(css = "a.dash.tablet.computer.only.ui.needsclick.dropdown.item")
    private WebElement menuBoard;

    @FindBy(css = "div.menu.transition.visible > div[data-action='add-board']")
    private WebElement addBoard;

    @FindBy(css = "div.ui.needsclick.user.dropdown.item")
    private WebElement userMenu;

    @FindBy(css = "div.menu.transition.visible > a[class=\"item\"][href=\"/logout\"]")
    private WebElement logOutButton;

    @FindBy(css = "div.menu.transition.visible > a[class=\"item\"][href=\"/profile\"]")
    private WebElement profileButton;

    @FindBy(css = "div.menu.transition.visible > a[class=\"item active selected\"][href=\"/profile\"]")
    private WebElement profileSelectedButton;

    @FindBy(css = "a.brand.item")
    private WebElement jalasoftIcon;

    @FindBy(xpath = "//a[@data-action='show-main-menu']")
    private WebElement generalMenu;

    /**
     * This method clicks the Board button.
     */
    public void clickMenuBoard() {
        wait.until(ExpectedConditions.elementToBeClickable(menuBoard));
        menuBoard.click();
    }

    /**
     * This method clicks the user menu.
     */
    public void clickUserMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(userMenu));
        userMenu.click();
    }

    /**
     * Method to perform a click on Logout.
     */
    public void clickOnLogOut() {
        logOutButton.click();
    }

    /**
     * Method to perform a click on Profile menu.
     *
     * @return The profile.
     */
    public Profile clickOnProfileMenu() {
        clickUserMenu();
        if (driver.findElements(
                By.cssSelector("div.menu.transition.visible > a[class=\"item\"][href=\"/profile\"]")).size() > 0) {
            profileButton.click();
        } else {
            profileSelectedButton.click();
        }
        return new Profile();
    }

    /**
     * Method to perform a click on Add board menu.
     *
     * @return The board page.
     */
    public BoardPage clickAddBoardMenu() {
        clickMenuBoard();
        addBoard.click();
        return new BoardPage();
    }

    /**
     * Method to perform a click on Jalasoft Icon.
     */
    public void clickJalasoftIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(jalasoftIcon));
        jalasoftIcon.click();
    }

    /**
     * Method to get the user name.
     *
     * @return The user name.
     */
    public String getUserName() {
        String userLogged = "";

        try {
            driver.manage().timeouts().implicitlyWait(DURATION, TimeUnit.SECONDS);
            wait.withTimeout(DURATION, TimeUnit.SECONDS);
            userLogged = this.userMenu.getText();
        } catch (NoSuchElementException e) {
            throw new WebDriverException(e);
        } finally {
            driver.manage().timeouts().implicitlyWait(Environment.getInstance().getTimeout(), TimeUnit.SECONDS);
            wait.withTimeout(Environment.getInstance().getTimeout(), TimeUnit.SECONDS);
        }
        return userLogged;
    }

    /**
     * Method to knows if the user menu is present.
     *
     * @return The user name.
     */
    public boolean isUserMenuPresent() {
        return !getUserName().equals("");
    }

    /**
     * Method to knows if the user is logged.
     *
     * @param account The user account.
     * @return The user account.
     */
    public boolean isUserLogged(final String account) {
        return getUserName().equals(account);
    }

    /**
     * Method to perform the logout of Mach2.
     *
     * @return The login page.
     */
    public LoginPage logout() {
        this.clickUserMenu();
        logOutButton.click();
        return new LoginPage();
    }

    /**
     * Method to perform a click on Profile menu.
     *
     * @return The general menu.
     */
    public SideBar clickGeneralMenu() {
        generalMenu.click();
        return new SideBar();
    }
}
