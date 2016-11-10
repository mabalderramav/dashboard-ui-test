package org.fundacionjala.dashboard.cucumber.stepdefinition.ui.dashboard;

import java.util.Map;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

import org.fundacionjala.dashboard.ui.pages.content.BoardPage;
import org.fundacionjala.dashboard.ui.pages.content.ConfigureWidget;
import org.fundacionjala.dashboard.ui.pages.content.widget.EnumConfigure;
import org.fundacionjala.dashboard.ui.pages.content.widget.EnumWizardWidget;
import org.fundacionjala.dashboard.ui.pages.content.widget.Widget;
import org.fundacionjala.dashboard.ui.pages.content.widget.WidgetPage;
import org.fundacionjala.dashboard.ui.pages.content.widget.WizardWidget;
import org.fundacionjala.dashboard.ui.pages.Steps;
import org.fundacionjala.dashboard.ui.pages.menu.TopMenu;

/**
 * Class to manage Step definition  for table widget of features.project.
 */
public class WidgetSteps {

    private static final String PROJECT_OPT = "project";

    /**
     * Method to add a widget for a features.project.
     *
     * @param type            Type of widget.
     * @param option          option type of widget to be selected.
     * @param newConfigureMap is a map tha contains all the configurations.
     */


    @When("^I add a (table|info|list) widget with the (PROJECT|STORY|ITERATION|BURN|STORY_TYPE|TASK_BURN) option$")
    public void iAddAWidgetInTheBoard(
            final String type, final EnumWizardWidget option, final Map<EnumConfigure, String> newConfigureMap) {
        Widget widgetType = Widget.valueOf(type.toUpperCase());

        TopMenu topMenu = new TopMenu();
        BoardPage boardPage = topMenu.clickAddBoardMenu();
        WidgetPage widgetPage = boardPage.clickAddWidgetMenu();

        // Makes click in the widget type tha could be table, info or list.
        WizardWidget wizardWidget = widgetPage.clickWidgetType(widgetType);

        // Execute the click on the service list option according to the sent.
        Map<EnumWizardWidget, Steps> strategyWidgetOption = wizardWidget.widgetStrategyOption();
        strategyWidgetOption.get(option).executeStep();

        // Execute the configurations if the table configuration is sent.
        ConfigureWidget configureWidget = new ConfigureWidget();
        if (newConfigureMap != null && !newConfigureMap.isEmpty() && !newConfigureMap.containsKey(null)) {
            configureWidget.setConfiguration(newConfigureMap);
        }
    }

    @When("^I add a (table|info|list) widget with the (PROJECT|STORY|ITERATION|BURN|STORY_TYPE|TASK_BURN) option without configuration$")
    public void iAddAWidgetInTheBoard(final String type, final EnumWizardWidget option){
        iAddAWidgetInTheBoard(type, option, null);
    }
    /**
     * Method to click on the save button.
     *
     * @param configurationOption Identify where the save button is pressed
     */
    @And("^I click (project|story) Save button$")
    public void iClickSaveButton(final String configurationOption) {
        if (configurationOption.equals(PROJECT_OPT)) {
            new ConfigureWidget().clickSave();
        } else {
            new ConfigureWidget().clickSaveConfigurationStoryItem();
        }
    }
}
