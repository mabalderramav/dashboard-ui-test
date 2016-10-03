package org.fundacionjala.dashboard.ui.pages.content;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.dashboard.ui.pages.AbstractBasePage;

/**
 * Class in progress.
 */
public class StoryItemPage extends AbstractBasePage {

    @FindBy(xpath = "//input[@autocomplete='off']")
    private WebElement autoCompleteProject;

    @FindBy(xpath = "//button[@data-action='save-wizard-config']")
    private WebElement save;

    /**
     * class in progress.
     * @param project class in progress.
     */
    public final void autoCompleteProject(final String project) {
        autoCompleteProject.sendKeys(project);
    }

    /**
     * class in progress.
     * @return class in progress.
     */
    public final StoryItemTable clickSaveConfigurationStoryItem() {
        save.click();
        return new StoryItemTable();
    }
}
