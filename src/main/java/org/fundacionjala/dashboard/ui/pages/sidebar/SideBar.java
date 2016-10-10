package org.fundacionjala.dashboard.ui.pages.sidebar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.dashboard.ui.pages.AbstractBasePage;
import org.fundacionjala.dashboard.ui.pages.content.MyDashboard;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Class to manage the sidebar of Mach2.
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

    /**
     * Method to click on dashboard button.
     *
     * @return The My dashboard page.
     */
    public MyDashboard clickMyDashBoardButton() {
        wait.until(ExpectedConditions.elementToBeClickable(myDashboardButton));
        myDashboardButton.click();
        return new MyDashboard();
    }

    /**
     * Method to perform a click on add group button.
     *
     * @return The group item button clicked.
     */
    public GroupItem clickAddGroupButton() {
        addGroupButton.click();
        return new GroupItem(this.driver.findElement(By.cssSelector("div.groups > div:last-child")));
    }

    /**
     * Method to perform a click on add board button.
     */
    public void clickAddBoardButton() {
        addBoardButton.click();
    }
}
