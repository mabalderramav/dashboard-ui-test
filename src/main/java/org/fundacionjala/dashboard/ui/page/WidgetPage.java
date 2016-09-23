package org.fundacionjala.dashboard.ui.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by brunovasquez on 9/22/2016.
 */
public class WidgetPage extends AbstractBasePage {

    @FindBy(css = "div.circular i.table-type")
    private WebElement widgetTable;

    public final ServiceForm clickOpenTable() {
        widgetTable.click();
        return new ServiceForm();
    }


}
