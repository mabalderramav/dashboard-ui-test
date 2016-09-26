package org.fundacionjala.dashboard.ui.pages.sidebar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.dashboard.ui.pages.AbstractBasePage;
import org.fundacionjala.dashboard.ui.pages.content.FavoritesPage;
import org.fundacionjala.dashboard.ui.pages.content.MyDashboard;
import org.fundacionjala.dashboard.ui.pages.content.SharedWithMePage;

/**
 * Created by JimmyRomero on 9/23/2016.
 */
public class SideBar extends AbstractBasePage {

    @FindBy(linkText = "Favorites")
    private WebElement favoritesButton;

    @FindBy(linkText = "Shared with me")
    private WebElement sharedWithMeButton;

    @FindBy(css = "span.inline-edit")
    private WebElement myDashboardButton;

    @FindBy(css = "div.ui > div[data-action='add-group']")
    private WebElement addGroupButton;

    @FindBy(css = "div.ui div.column[data-action='add-board']")
    private WebElement addBoardButton;

    @FindBy(css = "div.main.container.pusher.owner-permission.edit-permission.view-permission.owner.dimmed")
    private WebElement mask;

    public FavoritesPage clickFavoritesButton() {
        favoritesButton.click();
        return new FavoritesPage();
    }

    public SharedWithMePage clickSharedWithMeButton() {
        sharedWithMeButton.click();
        return new SharedWithMePage();
    }

    public MyDashboard clickMyDashBoardButton() {
        myDashboardButton.click();
        return new MyDashboard();
    }

    public GroupItem clickAddGroupButton() {
        addGroupButton.click();
        return new GroupItem(this.driver.findElement(By.cssSelector("div.groups > div:last-child")));
    }

    public void clickAddBoardButton() {
        addBoardButton.click();
    }
}
