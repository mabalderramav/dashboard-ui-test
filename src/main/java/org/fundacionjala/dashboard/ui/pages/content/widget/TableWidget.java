package org.fundacionjala.dashboard.ui.pages.content.widget;

import org.fundacionjala.dashboard.ui.pages.AbstractBasePage;
import org.fundacionjala.dashboard.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Manage Project table Widget page.
 */
public class TableWidget extends AbstractBasePage implements TypeWidget {
    @FindBy(xpath = "//table[@class='ui celled dash table table-widget sortable']")
    private WebElement projectTable;

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, String> getProjectType() {
        Map<String, String> result = new HashMap<>();
        List<WebElement> projectTableHeader = projectTable.findElements(By.tagName("th"));
        List<WebElement> projectTableRow = projectTable.findElements(By.tagName("tr"));

        for (int i = 0; i < projectTableRow.size(); i++) {
            String key = Utils.replaceSpaceWithUnderscore(projectTableHeader.get(i).getText());
            result.put(key, projectTableRow.get(i).getText());
        }
        return result;
    }
}

