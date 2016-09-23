package org.fundacionjala.dashboard.ui.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class TopMenu extends AbstractBasePage {

    @FindBy(css = "i[class='needsclick plus icon']")
    private WebElement menuBoard;

    @FindBy(css = "div.menu.transition.visible > div[data-action='add-board']")
    private WebElement addBoard;

    @FindBy(css = "div.ui.needsclick.user.dropdown.item")
    private WebElement dropDownList;

    @FindBy(css = "div.menu.transition.visible > a[class=\"item\"][href=\"/logout\"]")
    private WebElement logOutButton;

    @FindBy(css = "div.menu.transition.visible > a[class=\"item\"][href=\"/profile\"]")
    private WebElement profileButton;


    /**
     * this method click the button.
     */
    public final void clickMenuBoard() {
        menuBoard.click();
    }


    public final void clickOnDropDownList() {
        dropDownList.click();
    }

    public final void clickOnLogOut() {
        logOutButton.click();
    }


    public void clickOnProfile() {
       profileButton.click();
    }
}
