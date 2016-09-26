package org.fundacionjala.dashboard.ui.pages.sidebar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import org.fundacionjala.dashboard.ui.pages.AbstractBasePage;
import org.fundacionjala.dashboard.ui.pages.content.GroupPage;

/**
 * Created by JimmyRomero on 9/23/2016.
 */
public class GroupItem extends AbstractBasePage {

    private WebElement groupElement;

    public GroupItem(WebElement groupElement) {
        this.groupElement = groupElement;
    }

    public GroupPage clickOnGroup() {
        groupElement.findElement(By.className("inline-edit")).click();
        return new GroupPage();
    }

    public void doubleClickGroupName() {
        WebElement groupName = groupElement.findElement(By.className("inline-edit"));
        Action action = new Actions(driver)
                .doubleClick(groupName).build();
        action.perform();
    }

    public void editGroupName(String newGroupName) {
        groupElement.findElement(By.className("inline-edit-text")).sendKeys(newGroupName);
    }
}
