package org.fundacionjala.dashboard.cucumber.stepdefinition.ui.dashboard;

import cucumber.api.java.en.When;
import org.fundacionjala.dashboard.ui.pages.content.BoardPage;
import org.fundacionjala.dashboard.ui.pages.content.widget.ConfigWidget;
import org.fundacionjala.dashboard.ui.pages.content.widget.TypeWidget;
import org.fundacionjala.dashboard.ui.pages.content.widget.Widget;
import org.fundacionjala.dashboard.ui.pages.content.widget.WidgetPage;
import org.fundacionjala.dashboard.ui.pages.content.widget.WizardWidget;
import org.fundacionjala.dashboard.ui.pages.menu.TopMenu;

/**
 * Class to manage Step definition  for table widget of features.project.
 */
public class WidgetSteps {

    /**
     * Method to add a widget for a features.project.
     */
    @When("^I add a (table|info|list) widget in the board and I select the (Project|Story) option$")
    public void iAddATableWidgetInTheBoard(String typeArg, String optionArg) {
        Widget type = Widget.valueOf(typeArg.toUpperCase());
        TopMenu topMenu = new TopMenu();
        BoardPage boardPage = topMenu.clickAddBoardMenu();
        WidgetPage widgetPage = boardPage.clickAddWidgetMenu();
        WizardWidget wizardWidget = widgetPage.clickWidgetType(type);
        ConfigWidget configWidget = wizardWidget.clickOpenProject();
        TypeWidget typeWidget = configWidget.clickSaveConfigurationProject(type);
        //Map<String, String> tableProjectValues = typeWidget.getProjectType();
    }
}
