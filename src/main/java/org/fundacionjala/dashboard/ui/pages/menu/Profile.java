package org.fundacionjala.dashboard.ui.pages.menu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.dashboard.ui.pages.AbstractBasePage;

/**
 * Class to view the user profile.
 */
public class Profile extends AbstractBasePage {

    @FindBy(css = "button[data-action=\"add-instance\"]")
    private WebElement addServiceButton;

    /**
     * Method to perform a click to add service button.
     *
     * @return The service.
     */
    public Service clickAddServiceButton() {
        addServiceButton.click();
        return new Service();
    }

    /**
     * Method to perform a click the setting icon.
     *
     * @return The service.
     */
    public Service clickSetting() {
        driver.findElement(By.cssSelector("i.setting.link.icon")).click();
        return new Service();
    }
}
