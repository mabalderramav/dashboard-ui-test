package org.fundacionjala.dashboard.ui.pages.content;

import org.openqa.selenium.By;

import org.fundacionjala.dashboard.ui.pages.AbstractBasePage;

/**
 * Created by JimmyRomero on 9/23/2016.
 */
public class MyDashboard extends AbstractBasePage {


    public BoardPage clickBoardCard(final String boardName) {
        driver.findElement(By.xpath("//div[@class='truncated text item title' and text()='" + boardName + "']")).click();
        return new BoardPage();
    }
}
