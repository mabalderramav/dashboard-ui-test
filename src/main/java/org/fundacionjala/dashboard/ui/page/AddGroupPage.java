package org.fundacionjala.dashboard.ui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by JimmyRomero on 9/23/2016.
 */
public class AddGroupPage extends AbstractBasePage {

    private WebElement groupElement;
    private GroupPage groupPage;

    public AddGroupPage(WebElement groupElement) {
        this.groupElement = groupElement;
        this.groupPage = new GroupPage();
    }

    public GroupPage clickOnGroup() {
        groupElement.findElement(By.className("inline-edit")).click();
        return this.groupPage;
    }

    public void doubleClickGroupName() {
        WebElement groupName = groupElement.findElement(By.className("inline-edit"));
        Action action = new Actions(getDriver())
                .doubleClick(groupName).build();
        action.perform();
    }

    public void editGroupName(String newGroupName) {
        groupElement.findElement(By.className("inline-edit-text")).sendKeys(newGroupName);
    }
}
