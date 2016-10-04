package org.fundacionjala.dashboard.ui.pages.content.widget;

import org.fundacionjala.dashboard.ui.pages.AbstractBasePage;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class to config the table widget.
 */
public class ConfigWidget extends AbstractBasePage {

    private static final String TYPE_NOT_FOUND_MSG = "Type not found.";

    @FindBy(xpath = "//button[@data-action='save-wizard-config']")
    private WebElement saveButton;

    /**
     * Method to config the table features.project.
     *
     * @return the ProjectTableWidget object.
     */
    public final TypeWidget clickSaveConfigurationProject(Widget type) {
        TypeWidget typeWidget;
        saveButton.click();
        switch (type) {
            case TABLE:
                typeWidget = new TableWidget();
                break;
            case INFO:
                typeWidget = new InfoWidget();
                break;
            case LIST:
                throw new WebDriverException(TYPE_NOT_FOUND_MSG);
            default:
                throw new WebDriverException(TYPE_NOT_FOUND_MSG);
        }
        return typeWidget;
    }
}
