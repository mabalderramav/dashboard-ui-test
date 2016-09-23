package org.fundacionjala.dashboard.ui.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class BoardPage extends AbstractBasePage {

    @FindBy(xpath = "//span[contains(.,'WIDGET')]")
    private WebElement addWidget;

    @FindBy(css = "h3.ui span.inline-edit")
    private WebElement boardName;

    @FindBy(css = "form.board-title-form input.inline-edit-text")
    private WebElement boardNameEditable;

    public final WidgetPage clickAddWidgetMenu() {
        addWidget.click();
        return new WidgetPage();
    }

    public void changeBoardName(String newBoardName) {
        Action action = new Actions(getDriver())
                .doubleClick(boardName).build();
        action.perform();
        boardNameEditable.sendKeys(newBoardName);
    }
}
