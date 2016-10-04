package org.fundacionjala.dashboard.ui.pages.content.widget;

import org.fundacionjala.dashboard.ui.pages.AbstractBasePage;
import org.fundacionjala.dashboard.ui.pages.content.StoryItemPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by brunovasquez on 9/22/2016.
 */
public class WizardWidget extends AbstractBasePage {

    @FindBy(xpath = "//div[@id='mach-wizard']/div/div[3]/div/div/div[2]/div[1]/div[2]/div")
    private WebElement projectButton;

    @FindBy(xpath = "//div[@id='mach-wizard']/div/div[3]/div/div/div[2]/div[2]/div[2]/div")
    private WebElement storyButton;

    public final ConfigWidget clickOpenProject() {
        projectButton.click();
        return new ConfigWidget();
    }

    public final StoryItemPage clickOpenStoryItem() {
        storyButton.click();
        return new StoryItemPage();
    }
}
