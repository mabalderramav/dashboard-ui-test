package org.fundacionjala.dashboard.ui.pages.content.widget;

import org.fundacionjala.dashboard.ui.pages.AbstractBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * This is WidgetPage class.
 */
public class WidgetPage extends AbstractBasePage {

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
        } catch (Exception e) {
            wait.until(ExpectedConditions.elementToBeClickable(specificWidget));
            specificWidget.click();
            System.out.println("hola sip " + e.getMessage());
        }
        return new WizardWidget();
    }
}
