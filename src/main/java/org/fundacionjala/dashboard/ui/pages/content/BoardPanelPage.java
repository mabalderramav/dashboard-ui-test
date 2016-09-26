package org.fundacionjala.dashboard.ui.pages.content;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.dashboard.ui.pages.AbstractBasePage;

/**
 * Created by brunovasquez on 9/21/2016.
 */
public class BoardPanelPage extends AbstractBasePage {

    @FindBy(xpath = "//span[contains(.,'WIDGET')]")
    private WebElement addWidget;

    public final void clickAddBoard() {
        addWidget.click();
    }

}
