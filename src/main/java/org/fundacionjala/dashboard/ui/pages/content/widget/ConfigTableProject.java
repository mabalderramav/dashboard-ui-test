package org.fundacionjala.dashboard.ui.pages.content.widget;

import org.fundacionjala.dashboard.ui.pages.AbstractBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class to config the table widget.
 */
public class ConfigTableProject extends AbstractBasePage {

    private static final String TYPE_NOT_FOUND_MSG = "Type not found.";

    @FindBy(xpath = "//button[@data-action='save-wizard-config']")
    private WebElement saveButton;

    /**
     * Method to config the table features.project.
     *
     * @return the ProjectTableWidget object.
     */
    public final ProjectTypeWidget clickSaveConfigurationProject(Widget type) throws ExceptionWidget {
        ProjectTypeWidget projectTypeWidget;
        saveButton.click();
        switch (type) {
            case TABLE:
                projectTypeWidget = new ProjectTableWidget();
                break;
            case INFO:
                projectTypeWidget = new ProjectInfoWidget();
                break;
            default:
                throw new ExceptionWidget(TYPE_NOT_FOUND_MSG);
        }
        return projectTypeWidget;
    }
}
