package org.fundacionjala.dashboard.ui.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by AlvaroDaza on 9/23/2016.
 */
public class Profile extends AbstractBasePage {


    @FindBy(css = "button[data-action=\"add-instance\"]")
    private WebElement addServiceButton;

    @FindBy(css = "div.ui.selection.dropdown")
    private WebElement dropDownListOfServices;

    @FindBy(xpath = "//div[@class=\"menu transition visible\"] /div[text()=\"Pivotal Tracker\"]")
    private WebElement pivotalTrackerDropDownListItem;

    @FindBy(name = "token")
    private WebElement tokenTextField;

    @FindBy(name = "description")
    private WebElement descriptionTextField;

    @FindBy(css = "div.ui.shadowless.top.sidebar.overlay.visible  >div.ui.stackable.one.column.grid.page >div.column >div.ui.segment >form.ui.form >div.dash.floated.content >button.ui.right.floated.blue.submit.button")
    private WebElement saveButton;

    public void clickAddServiceButton() {
        addServiceButton.click();
    }

    public void clickDropDownList() {
        dropDownListOfServices.click();
    }

    public void clickPivotalTrackerItem() {
        pivotalTrackerDropDownListItem.click();
    }

    public void insertTheInformationRequired(String token) {
        tokenTextField.clear();
        tokenTextField.sendKeys(token);
        descriptionTextField.clear();
        descriptionTextField.sendKeys("my description");
    }

    public void clickSaveServices() {
        saveButton.click();
    }
}
