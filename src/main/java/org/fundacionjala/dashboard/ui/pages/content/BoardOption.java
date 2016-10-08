package org.fundacionjala.dashboard.ui.pages.content;

import org.fundacionjala.dashboard.ui.pages.AbstractBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * This Class manage the side board options.
 */
public class BoardOption extends AbstractBasePage {

    @FindBy(xpath = "//button[@data-action='save-wizard-config']")
    private WebElement shareBoard;

    @FindBy(css =
            "div.menu.right.owner-permission.edit-permission.view-permission.owner.transition.visible"
                    + " > a[data-action=\"delete-board\"]")
    private WebElement deleteBoard;

    @FindBy(css = "div.ui.positive.button")
    private WebElement acceptDeleteButton;

    /**
     * Method to share a board.
     */
    public final void shareABoard() {
        shareBoard.click();
    }

    /**
     * Method to delete the board.
     */
    public final void deleteBoardMach() {
        deleteBoard.click();
        wait.until(ExpectedConditions.elementToBeClickable(acceptDeleteButton));
        acceptDeleteButton.click();
    }
}
