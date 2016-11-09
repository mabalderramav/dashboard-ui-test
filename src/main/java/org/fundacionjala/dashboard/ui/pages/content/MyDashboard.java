package org.fundacionjala.dashboard.ui.pages.content;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.fundacionjala.dashboard.ui.pages.AbstractBasePage;

/**
 * Class to Manage the boards.
 */
public class MyDashboard extends AbstractBasePage {

    @FindBy(css = "div.group.item.truncated.text > div.menu.ui-sortable")
    private WebElement boardsList;

    @FindBy(xpath = "//div[@class='truncated text item title' and text()='")
    private WebElement boardBase;

    @FindBy(css = "div.main.container")
    private WebElement mainContainer;

    /**
     * Makes rigth click to an specific board.
     *
     * @param board WebElement with a specific board.
     * @return a new BoardOption.
     */
    public BoardOption rightClickBoardCard(final WebElement board) {
        WebElement boardName = board.findElement(By.className("inline-edit"));
        Action action = new Actions(driver)
                .contextClick(boardName).build();
        action.perform();
        return new BoardOption();
    }

    /**
     * Deletes all boards of the MACH2.
     */
    public void deleteAllBoards() {
        wait.until(ExpectedConditions.visibilityOf(boardsList));
        boardsList.findElements(By.tagName("a")).forEach(element -> {
            BoardOption boardOption = rightClickBoardCard(element);
            boardOption.deleteBoardMach();
        });
    }

    /**
     * Method to perform a click on the right side of the page.
     */
    public void clickInTheRightSideOfPage() {
        //This positions define a point in the right component of the screen where to make click.
        final int positionX = 200;
        final int positionY = 100;

        //Makes click in the position x and y of the main container.
        wait.until(ExpectedConditions.elementToBeClickable(mainContainer));
        Actions action = new Actions(driver);
        action.moveToElement(mainContainer, positionX, positionY).doubleClick().build().perform();
    }
}
