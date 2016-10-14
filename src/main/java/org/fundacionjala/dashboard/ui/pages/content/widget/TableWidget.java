package org.fundacionjala.dashboard.ui.pages.content.widget;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.dashboard.ui.pages.AbstractBasePage;
import org.fundacionjala.dashboard.utils.Utils;

/**
 * Manage Project table Widget page.
 */
public class TableWidget extends AbstractBasePage implements TypeWidget<List<Map<String, String>>> {

    @FindBy(xpath = "//table[@class='ui celled dash table table-widget sortable']")
    private WebElement projectTable;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, String>> getDataFromWidget() {
        List<Map<String, String>> result = new ArrayList<>();
        List<WebElement> projectTableHeader = projectTable.findElements(By.tagName("th"));

        projectTable.findElements(By.cssSelector("tbody>tr")).forEach(element -> {
            List<WebElement> projectTableRow = element.findElements(By.cssSelector("tbody>tr>td"));
            Map<String, String> rowResult = new HashMap<>();
            for (int j = 0; j < projectTableRow.size(); j++) {
                String key = Utils.replaceSpaceWithUnderscore(projectTableHeader.get(j).getText());
                rowResult.put(key, projectTableRow.get(j).getText());
            }
            result.add(rowResult);
        });
        Collections.sort(result, (row1, row2) -> row1.get("name").compareTo(row2.get("name")));

        return result;
    }

    /**
     * Method to count how much of columns is displayed.
     *
     * @return the quantity of columns.
     */
    public int countDisplayedColumns() {
        return projectTable.findElements(By.tagName("th")).size();
    }

    /**
     * This method change the parameters to Lower case.
     *
     * @param tableStoriesValues list of table values.
     * @return list.
     */
    public List<Map<String, String>> getConvertLowerCase(final List<Map<String, String>> tableStoriesValues) {
        for (Map<String, String> tableData : tableStoriesValues) {
            tableData.put("type", tableData.get("type").toLowerCase());
            tableData.put("state", tableData.get("state").toLowerCase());
        }
        return tableStoriesValues;
    }
}

