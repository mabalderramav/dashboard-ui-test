package org.fundacionjala.dashboard.ui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by brunovasquez on 9/23/2016.
 */
public class StoryItemTable extends AbstractBasePage {
    @FindBy(xpath = "//table[@class='ui celled dash table table-widget sortable']")
    private WebElement storyTable;

    public final Map<String, String> getStoryTable() {
        Map<String, String> result = new HashMap<>();
        List<WebElement> storyTableHeader = storyTable.findElements(By.tagName("th"));
        List<WebElement> storyTableRow = storyTable.findElements(By.tagName("tr"));

        for (int i = 0; i < storyTableRow.size(); i++) {
            String key = replaceSpaceWithUnderscore(storyTableHeader.get(i).getText());
            result.put(key, storyTableRow.get(i).getText());
        }
         return result;
    }


    public static String replaceSpaceWithUnderscore(final String key) {
        return key.toLowerCase().replaceAll(" ", "_");
    }
}
