package org.fundacionjala.dashboard.ui.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

/**
 * Created by brunovasquez on 9/21/2016.
 */
public class HomePage extends AbstractBasePage {

    @FindBy(xpath = "//i[@class='needsclick plus icon']")
    private WebElement menuBoard;
    @FindBy(xpath = "/html/body/div[5]/div[1]/div/div/div[1]/a[1]/div/div[1]")
    private WebElement addBoard;
    @FindBy(xpath = "/html/body/div[6]/div[2]/div[2]/div[1]/div[2]/div/h3/span[1]")
    private WebElement boardName;
    @FindBy(xpath = "/html/body/div[6]/div[2]/div[2]/div[1]/div[1]/div[1]/div/img")
    private WebElement boardIcon;


    /**
     * this method click the button.
     */
    public final void clickMenuBoard() {
        menuBoard.click();
    }
    public final BoardPanelPage clickAddBoard() {
        addBoard.click();
        return new BoardPanelPage();
    }

    /**
     * This method close the browser.
     */
    public final void clickClose() {
        getDriver().quit();
    }

    public final void changeBoardName(String newBoardName){
        //boardName.clear();
        Action action = new Actions(getDriver())
                .doubleClick(boardName).build();
        action.perform();
//        boardName.click();
//        boardName.click();
 //       boardName.sendKeys(newBoardName);
    }
}
