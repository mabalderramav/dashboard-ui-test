package org.fundacionjala.dashboard.ui.pages.content.widget;

import org.fundacionjala.dashboard.ui.pages.AbstractBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Manage Project Info Widget page.
 */
public class ProjectInfoWidget extends AbstractBasePage implements ProjectTypeWidget {
    @FindBy(css = "div.info-fields > div.ui.two.column.centered.grid.aligned.basic.field.segment")
    private WebElement projectInfo;

    /**
     * {@inheritDoc}
     */
    @Override
    public final Map<String, String> getProjectType() {
        Map<String, String> result = new HashMap<>();
        List<WebElement> projectInfoHeader = projectInfo.findElements(By.className("selected-name"));
        List<WebElement> projectInfoRow = projectInfo.findElements(By.className("selected-value"));

//        for (WebElement element : projectInfoHeader){
//
//        }
//        for (int i = 0; i < projectInfoRow.size(); i++) {
//            String key = Utils.replaceSpaceWithUnderscore(projectInfoHeader.get(i).getText());
//            result.put(key, projectInfoRow.get(i).getText());
//        }
        return result;
    }
}
