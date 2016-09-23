package org.fundacionjala.dashboard.ui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by JimmyRomero on 9/23/2016.
 */
public class SideBar extends AbstractBasePage {
    @FindBy(linkText = "Favorites")
    WebElement favoritesButton;

    @FindBy(linkText = "Shared with me")
    WebElement sharedWithMeButton;

    @FindBy(css = "span.inline-edit")
    WebElement myDashboardButton;

    @FindBy(css = "div.ui > div[data-action='add-group']")
    WebElement addGroup;

    @FindBy(css = "div.ui div.column[data-action='add-board']")
    WebElement addBoard;


    public final FavoritesPage clickFavoritesButton(){
        favoritesButton.click();
        return new FavoritesPage();
    }

    public final SharedWithMePage clicSharedWithMeButton(){
        sharedWithMeButton.click();
        return new SharedWithMePage();
    }

    public final MyDashboardPage clickMyDashBoardButton(){
        myDashboardButton.click();
        return new MyDashboardPage();
    }

    public final AddGroupPage clickAddGroupButton(){
        addGroup.click();
        return new AddGroupPage(this.getDriver().findElement(By.cssSelector("div.groups >div:last-child")));

    }

    public final AddBoardPage clickAddBoardButton(){
        addBoard.click();
        return new AddBoardPage(this.getDriver().findElement(By.cssSelector("div.group div.menu a.text.active")));
    }

}
