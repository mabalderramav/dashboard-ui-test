package org.fundacionjala.dashboard.ui.pages.sidebar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import org.fundacionjala.dashboard.ui.pages.AbstractBasePage;
import org.fundacionjala.dashboard.ui.pages.content.BoardPage;

/**
 * Created by JimmyRomero on 9/23/2016.
 */
public class BoardItem extends AbstractBasePage {

    private WebElement boardElement;

    public BoardItem(WebElement boardElement) {
        this.boardElement = boardElement;
    }

    public BoardPage clickOnBoard() {
        boardElement.findElement(By.className("inline-edit")).click();
        return new BoardPage();
    }

    public void doubleClickBoardName() {
        WebElement groupName = boardElement.findElement(By.className("inline-edit"));
        Action action = new Actions(driver)
                .doubleClick(groupName).build();
        action.perform();
    }

    public void editBoardName(String newGroupName) {
        boardElement.findElement(By.className("inline-edit-text")).sendKeys(newGroupName);
    }
}
