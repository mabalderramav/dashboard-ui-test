package org.fundacionjala.dashboard.ui.pages.sidebar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import org.fundacionjala.dashboard.ui.pages.AbstractBasePage;
import org.fundacionjala.dashboard.ui.pages.content.BoardPage;

/**
 * Class to manage the board item in the sidebar.
 */
public class BoardItem extends AbstractBasePage {

    private final WebElement boardElement;

    /**
     * Method to find the board element.
     *
     * @param newBoardElement The board element.
     */
    public BoardItem(final WebElement newBoardElement) {
        this.boardElement = newBoardElement;
    }

    /**
     * Method to click on board.
     *
     * @return The board page.
     */
    public BoardPage clickOnBoard() {
        boardElement.findElement(By.className("inline-edit")).click();
        return new BoardPage();
    }

    /**
     * Method to change the board name.
     */
    public void doubleClickBoardName() {
        WebElement groupName = boardElement.findElement(By.className("inline-edit"));
        Action action = new Actions(driver)
                .doubleClick(groupName).build();
        action.perform();
    }

    /**
     * Method to edit the board name.
     *
     * @param newGroupName The name of the group changed.
     */
    public void editBoardName(final String newGroupName) {
        boardElement.findElement(By.className("inline-edit-text")).sendKeys(newGroupName);
    }
}
