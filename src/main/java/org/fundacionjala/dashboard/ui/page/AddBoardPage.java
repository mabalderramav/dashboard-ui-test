package org.fundacionjala.dashboard.ui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by JimmyRomero on 9/23/2016.
 */
public class AddBoardPage extends AbstractBasePage {
    private WebElement boardElement;
    private BoardPage boardPage;

    public AddBoardPage(WebElement boardElement) {
        this.boardElement = boardElement;
        this.boardPage = new BoardPage();
    }

    public BoardPage clickOnBoard() {
        boardElement.findElement(By.className("inline-edit")).click();
        return this.boardPage;
    }

    public void doubleClickBoardName() {
        WebElement groupName = boardElement.findElement(By.className("inline-edit"));
        Action action = new Actions(getDriver())
                .doubleClick(groupName).build();
        action.perform();
    }

    public void editBoardName(String newGroupName) {
        boardElement.findElement(By.className("inline-edit-text")).sendKeys(newGroupName);
    }
}
