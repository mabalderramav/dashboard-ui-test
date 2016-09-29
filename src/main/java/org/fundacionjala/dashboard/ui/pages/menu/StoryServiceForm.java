package org.fundacionjala.dashboard.ui.pages.menu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.dashboard.ui.pages.AbstractBasePage;
import org.fundacionjala.dashboard.ui.pages.content.widget.ConfigTableProject;
import org.fundacionjala.dashboard.ui.pages.content.StoryItemPage;

/**
 * Created by brunovasquez on 9/22/2016.
 */
public class StoryServiceForm extends AbstractBasePage {

    @FindBy(xpath = "//div[@id='mach-wizard']/div/div[3]/div/div/div[2]/div[1]/div[2]/div")
    private WebElement projectButton;

    @FindBy(xpath = "//div[@id='mach-wizard']/div/div[3]/div/div/div[2]/div[2]/div[2]/div")
    private WebElement storyButton;

    public final ConfigTableProject clickOpenProject() {
        projectButton.click();
        return new ConfigTableProject();
    }

    public final StoryItemPage clickOpenStoryItem() {
        storyButton.click();
        return new StoryItemPage();
    }
}
