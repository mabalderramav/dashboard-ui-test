package org.fundacionjala.dashboard.ui.pages.content;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.dashboard.ui.pages.AbstractBasePage;
import org.fundacionjala.dashboard.ui.pages.menu.StoryServiceForm;

/**
 * Created by brunovasquez on 9/22/2016.
 */
public class WidgetPage extends AbstractBasePage {

    @FindBy(css = "div.circular i.table-type")
    private WebElement widgetTable;

    public final StoryServiceForm clickTableWidgetType() {
        widgetTable.click();
        return new StoryServiceForm();
    }

}
