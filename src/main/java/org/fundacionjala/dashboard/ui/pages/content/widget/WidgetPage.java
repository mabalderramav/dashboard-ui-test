package org.fundacionjala.dashboard.ui.pages.content.widget;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.fundacionjala.dashboard.ui.pages.AbstractBasePage;

/**
 * This is WidgetPage class.
 */
public class WidgetPage extends AbstractBasePage {
    private static final Logger LOGGER = LogManager.getLogger(WidgetPage.class);

    @FindBy(css = "div.widgets.list")
    private WebElement widgetList;

    /**
     * This method get a Story service form.
     *
     * @param type Widget type for example table, info, list.
     * @return StoryServiceForm.
     */
    public WizardWidget clickWidgetType(final Widget type) {
        WebElement specificWidget = driver.findElement(By.cssSelector("div.circular i." + type + "-type"));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(specificWidget));
            specificWidget.click();
        } catch (WebDriverException e) {
            LOGGER.info("Waiting for widget element to be clickable");
            clickWidgetType(type);
        }
        return new WizardWidget();
    }
}
