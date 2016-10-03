package org.fundacionjala.dashboard.ui.pages.menu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.dashboard.ui.pages.AbstractBasePage;

/**
 * Class to add comments.
 */
public class Service extends AbstractBasePage {

    @FindBy(css = "div.ui.selection.dropdown")
    private WebElement dropDownListOfServices;

    @FindBy(css = "input[name='token']")
    private WebElement tokenTextField;

    @FindBy(name = "description")
    private WebElement descriptionTextField;

    @FindBy(css = "div.ui.shadowless.top.sidebar.overlay.visible button.ui.right.floated.blue.submit.button")
    private WebElement saveButton;

    /**
     * to comment.
     * @param serviceName to comment.
     */
    public void selectServiceDropdown(final String serviceName) {
        dropDownListOfServices.click();
        driver.findElement(By.xpath("//div[@class='menu transition visible']/div[text()='"
                + serviceName + "']")).click();
    }

    /**
     * to comment.
     * @param token to comment.
     */
    public void setTokenTextField(final String token) {
        tokenTextField.clear();
        tokenTextField.sendKeys(token);
    }

    /**
     * to comment.
     * @param description to comment.
     */
    public void setDescriptionTextField(final String description) {
        descriptionTextField.clear();
        descriptionTextField.sendKeys(description);
    }

    /**
     * to comment.
     * @return to comment.
     */
    public Profile clickSaveButton() {
        saveButton.click();
        driver.navigate().refresh();
        return new Profile();
    }
}
