package org.fundacionjala.dashboard.ui.pages.menu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.dashboard.ui.pages.AbstractBasePage;

public class Profile extends AbstractBasePage {

    @FindBy(css = "button[data-action=\"add-instance\"]")
    private WebElement addServiceButton;

    public Service clickAddServiceButton() {
        addServiceButton.click();
        return new Service();
    }

    public Service clickSetting() {
        driver.findElement(By.cssSelector("i.setting.link.icon")).click();
        return new Service();
    }

}
