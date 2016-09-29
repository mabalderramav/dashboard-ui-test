package org.fundacionjala.dashboard.ui.pages.content;

import org.fundacionjala.dashboard.ui.pages.content.widget.WidgetPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.dashboard.ui.pages.AbstractBasePage;

public class BoardPage extends AbstractBasePage {

    @FindBy(css = "a.dash.tablet.computer.only.ui.add-widget.item")
    private WebElement addWidget;

    @FindBy(css = "h3.ui span.inline-edit")
    private WebElement boardName;

    @FindBy(css = "form.board-title-form input.inline-edit-text")
    private WebElement boardNameEditable;

    public WidgetPage clickAddWidgetMenu() {
        addWidget.click();
        return new WidgetPage();
    }

    public void changeBoardName(String newBoardName) {
        Action action = new Actions(driver)
                .doubleClick(boardName).build();
        action.perform();
        boardNameEditable.sendKeys(newBoardName);
    }
}
