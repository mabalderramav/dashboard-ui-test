package org.fundacionjala.dashboard.ui.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class TopMenu extends AbstractBasePage {

    @FindBy(css = "i[class='needsclick plus icon']")
    private WebElement menuBoard;

    @FindBy(css = "div.menu.transition.visible > div[data-action='add-board']")
    private WebElement addBoard;

    @FindBy(css = "div.main.container.pusher.owner-permission.edit-permission.view-permission.owner.dimmed")
    private WebElement menuIcon;

    /**
     * this method click the button.
     */
    public final void clickMenuBoard() {
        menuBoard.click();
    }

    public BoardPage clickAddBoardMenu() {
        clickMenuBoard();
        addBoard.click();
        return new BoardPage();
    }

    public void clickMainMenuIcon(){
        menuIcon.click();
    }


}
