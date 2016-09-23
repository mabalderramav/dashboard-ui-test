package org.fundacionjala.dashboard.ui.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WidgetPage extends AbstractBasePage{
    //@FindBy(xpath = "//div[2]/div[2]/div/div/div/div/div[2]/div")
    @FindBy(css = "div.circular i.table-type")
    private WebElement widgetTable;

    public final ServiceForm clickTableWidgetType() {
        widgetTable.click();
        return new ServiceForm();
    }


}




//i[contains(@class,'huge table-type icon')]
// i[contains(@class,'huge table-type icon')]
//i[@class='huge table-type icon']