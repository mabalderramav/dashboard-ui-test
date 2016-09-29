package org.fundacionjala.dashboard.ui.pages.menu;

import org.fundacionjala.dashboard.ui.pages.LoginPage;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.dashboard.ui.pages.AbstractBasePage;
import org.fundacionjala.dashboard.ui.pages.content.BoardPage;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TopMenu extends AbstractBasePage {

    @FindBy(css = "i[class='needsclick plus icon']")
    private WebElement menuBoard;

    @FindBy(css = "div.menu.transition.visible > div[data-action='add-board']")
    private WebElement addBoard;

    @FindBy(css = "span.dash.tablet.computer.only.needsclick.user.name")
    private WebElement userMenu;

    @FindBy(css = "div.menu.transition.visible > a[class=\"item\"][href=\"/logout\"]")
    private WebElement logOutButton;

    @FindBy(css = "div.menu.transition.visible > a[class=\"item\"][href=\"/profile\"]")
    private WebElement profileButton;

    @FindBy(css = "a.brand.item")
    private WebElement jalasoftIcon;

    /**
     * this method click the button.
     */
    public void clickMenuBoard() {
        menuBoard.click();
    }

    public void clickUserMenu() {
        userMenu.click();
    }

    public void clickOnLogOut() {
        logOutButton.click();
        driver.navigate().back();
        driver.navigate().back();
    }

    public Profile clickOnProfileMenu() {
        clickUserMenu();
        profileButton.click();
        return new Profile();
    }

    public BoardPage clickAddBoardMenu() {
        clickMenuBoard();
        addBoard.click();
        return new BoardPage();
    }

    public void clickJalasoftIcon() {
        jalasoftIcon.click();
    }


    public String getUserName(){
        String userLogged = "";
        try{
      //      wait.until(ExpectedConditions.visibilityOf(userMenu));
            userLogged = this.userMenu.getText();
        }
        catch (WebDriverException e){
            throw new WebDriverException(e);
        }
        return userLogged;
    }

    public boolean isUserMenuPresent(){
        return !getUserName().equals("");
    }

    public boolean isUserLogged(String account){
        return getUserName().equals(account);
    }

    public LoginPage logout(){
        this.clickUserMenu();
        logOutButton.click();

        return new LoginPage();
    }
}
