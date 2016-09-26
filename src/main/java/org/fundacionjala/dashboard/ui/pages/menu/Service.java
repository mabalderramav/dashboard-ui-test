package org.fundacionjala.dashboard.ui.pages.menu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.dashboard.ui.pages.AbstractBasePage;

public class Service extends AbstractBasePage {

    @FindBy(css = "div.ui.selection.dropdown")
    private WebElement dropDownListOfServices;

    @FindBy(css = "input[name='token']")
    private WebElement tokenTextField;

    @FindBy(name = "description")
    private WebElement descriptionTextField;

    @FindBy(css = "div.ui.shadowless.top.sidebar.overlay.visible button.ui.right.floated.blue.submit.button")
    private WebElement saveButton;

    public void selectServiceDropdown(String serviceName) {
        dropDownListOfServices.click();
        driver.findElement(By.xpath("//div[@class='menu transition visible']/div[text()='" + serviceName + "']")).click();
    }

    public void setTokenTextField(String token) {
        tokenTextField.clear();
        tokenTextField.sendKeys(token);
    }

    public void setDescriptionTextField(String description) {
        descriptionTextField.clear();
        descriptionTextField.sendKeys(description);
    }

    public Profile clickSaveButton() {
        saveButton.click();
        driver.navigate().refresh();
        return new Profile();
    }
}
