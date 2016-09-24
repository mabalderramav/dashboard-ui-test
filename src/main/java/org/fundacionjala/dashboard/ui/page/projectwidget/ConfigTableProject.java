package org.fundacionjala.dashboard.ui.page.projectwidget;

import org.fundacionjala.dashboard.ui.page.AbstractBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class to config the table widget.
 */
public class ConfigTableProject extends AbstractBasePage {

    @FindBy(xpath = "//button[@data-action='save-wizard-config']")

    private WebElement saveButton;

    /**
     * Method to config the table features.project.
     *
     * @return the ProjectTableWidget object.
     */
    public final ProjectTableWidget clickSaveConfigurationProject() {
        saveButton.click();
        return new ProjectTableWidget();
    }
}
