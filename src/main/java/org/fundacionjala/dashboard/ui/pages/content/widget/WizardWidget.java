package org.fundacionjala.dashboard.ui.pages.content.widget;

import org.fundacionjala.dashboard.ui.pages.AbstractBasePage;
import org.fundacionjala.dashboard.ui.pages.content.StoryItemPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class used to manage the most used options.
 */
public class WizardWidget extends AbstractBasePage {

    //@FindBy(xpath = "//div[@id='mach-wizard']/div/div[3]/div/div/div[2]/div[1]/div[2]/div")
    @FindBy(xpath = "//h4[contains(text(), 'Projects')]")
    private WebElement projectButton;

    @FindBy(xpath = "//div[@id='mach-wizard']/div/div[3]/div/div/div[2]/div[2]/div[2]/div")
    private WebElement storyButton;

    /**
     * Method to select the 'Open project' options.
     *
     * @return The 'Open project' option selected.
     */
    public final ConfigWidget clickOpenProject() {
        projectButton.click();
        return new ConfigWidget();
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
