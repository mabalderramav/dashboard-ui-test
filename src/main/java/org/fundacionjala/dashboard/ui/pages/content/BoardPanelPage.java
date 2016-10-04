package org.fundacionjala.dashboard.ui.pages.content;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.dashboard.ui.pages.AbstractBasePage;

/**
 * Class to manage widgets in the board.
 */
public class BoardPanelPage extends AbstractBasePage {

    @FindBy(xpath = "//span[contains(.,'WIDGET')]")
    private WebElement addWidget;

    /**
     * Method to perform a click on add board.
     */
    public final void clickAddBoard() {
        addWidget.click();
    }
}
