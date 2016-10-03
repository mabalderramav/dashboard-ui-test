package org.fundacionjala.dashboard.ui.pages.content;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.fundacionjala.dashboard.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.dashboard.ui.pages.AbstractBasePage;

/**
 * Class to Manage story items.
 */
public class StoryItemTable extends AbstractBasePage {

    @FindBy(xpath = "//table[@class='ui celled dash table table-widget sortable']")
    private WebElement storyTable;

    /**
     * Method to get all stories from the table.
     *
     * @return The result map.
     */
    public final Map<String, String> getStoryTable() {
        Map<String, String> result = new HashMap<>();
        List<WebElement> storyTableHeader = storyTable.findElements(By.tagName("th"));
        List<WebElement> storyTableRow = storyTable.findElements(By.tagName("tr"));

        for (int i = 0; i < storyTableRow.size(); i++) {
            String key = Utils.replaceSpaceWithUnderscore(storyTableHeader.get(i).getText());
            result.put(key, storyTableRow.get(i).getText());
        }
        return result;
    }
}
