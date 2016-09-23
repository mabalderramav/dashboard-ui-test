package org.fundacionjala.dashboard.ui.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by brunovasquez on 9/21/2016.
 */
public class BoardPanelPage extends AbstractBasePage {

  //  @FindBy(xpath = "//i[@class='needsclick plus icon']")
    @FindBy(xpath = "//span[contains(.,'WIDGET')]")
    private WebElement addWidget;

    public final void clickAddBoard() {
        addWidget.click();
    }


}
