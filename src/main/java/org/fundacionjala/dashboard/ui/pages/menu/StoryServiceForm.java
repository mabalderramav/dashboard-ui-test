package org.fundacionjala.dashboard.ui.pages.menu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.dashboard.ui.pages.AbstractBasePage;
import org.fundacionjala.dashboard.ui.pages.content.ConfigTableProject;
import org.fundacionjala.dashboard.ui.pages.content.StoryItemPage;

/**
 * Class used to manage the most used options.
 */
public class StoryServiceForm extends AbstractBasePage {

    @FindBy(xpath = "//div[@id='mach-wizard']/div/div[3]/div/div/div[2]/div[1]/div[2]/div")
    private WebElement projectButton;

    @FindBy(xpath = "//div[@id='mach-wizard']/div/div[3]/div/div/div[2]/div[2]/div[2]/div")
    private WebElement storyButton;

    /**
     * Method to select the 'Open project' options.
     *
     * @return The 'Open project' option selected.
     */
    public final ConfigTableProject clickOpenProject() {
        projectButton.click();
        return new ConfigTableProject();
    }

    /**
     * Method to select the 'Open story' options.
     *
     * @return The 'Open story' option selected.
     */
    public final StoryItemPage clickOpenStoryItem() {
        storyButton.click();
        return new StoryItemPage();
    }
}
