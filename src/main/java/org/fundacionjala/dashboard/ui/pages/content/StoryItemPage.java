package org.fundacionjala.dashboard.ui.pages.content;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.dashboard.ui.pages.AbstractBasePage;

/**
 * Created by brunovasquez on 9/22/2016.
 */
public class StoryItemPage extends AbstractBasePage {

    @FindBy(xpath = "//input[@autocomplete='off']")
    private WebElement autoCompleteProject;

    @FindBy(xpath = "//button[@data-action='save-wizard-config']")
    private WebElement save;

    /**
     * The method complete the project search
     *
     * @param project
     */
    public final void autoCompleteProject(String project) {
        autoCompleteProject.sendKeys(project);
    }

    /**
     * The method
     *
     * @return
     */
    public final StoryItemTable clickSaveConfigurationStoryItem() {
        save.click();
        return new StoryItemTable();
    }

}
