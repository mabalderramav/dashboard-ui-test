package org.fundacionjala.dashboard.ui.pages.sidebar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import org.fundacionjala.dashboard.ui.pages.AbstractBasePage;

/**
 * Class to manage the group items.
 */
public class GroupItem extends AbstractBasePage {

    private WebElement groupElement;

    /**
     * Method to manage the group item.
     *
     * @param newGroupElement The group element.
     */
    public GroupItem(final WebElement newGroupElement) {
        this.groupElement = newGroupElement;
    }

    /**
     * Method to perform a double click on group name.
     */
    public void doubleClickGroupName() {
        WebElement groupName = groupElement.findElement(By.className("inline-edit"));
        Action action = new Actions(driver)
                .doubleClick(groupName).build();
        action.perform();
    }

    /**
     * Method to change the group name.
     *
     * @param newGroupName The name of the group changed.
     */
    public void editGroupName(final String newGroupName) {
        groupElement.findElement(By.className("inline-edit-text")).sendKeys(newGroupName);
    }
}
