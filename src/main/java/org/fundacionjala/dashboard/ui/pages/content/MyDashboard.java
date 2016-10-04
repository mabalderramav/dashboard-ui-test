package org.fundacionjala.dashboard.ui.pages.content;

import org.openqa.selenium.By;

import org.fundacionjala.dashboard.ui.pages.AbstractBasePage;

/**
 * Class to Manage the boards.
 */
public class MyDashboard extends AbstractBasePage {

    /**
     * Method to click on board card.
     *
     * @param boardName The name of the board.
     * @return The board page.
     */
    public BoardPage clickBoardCard(final String boardName) {
        driver.findElement(By.xpath("//div[@class='truncated text item title' and text()='"
                + boardName + "']")).click();
        return new BoardPage();
    }
}
