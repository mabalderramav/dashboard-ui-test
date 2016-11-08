package org.fundacionjala.dashboard.cucumber.stepdefinition.ui.story;

import cucumber.api.java.en.When;

import org.fundacionjala.dashboard.cucumber.stepdefinition.api.ResourcesSteps;
import org.fundacionjala.dashboard.ui.pages.content.ConfigureWidget;
import org.fundacionjala.dashboard.ui.pages.content.widget.WidgetPage;
import org.fundacionjala.dashboard.ui.pages.content.widget.WizardWidget;

import static org.fundacionjala.dashboard.ui.pages.content.widget.Widget.TABLE;

/**
 * Is in charge to manage story steps definitions.
 */
public class StorySteps {

    private ResourcesSteps resources;
    private WidgetPage widgetPage;
    private WizardWidget wizardWidget;


    /**
     * Method to Select the Story Items option form the UI.
     */
    @When("^I select Story Items option$")
    public void iSelectTheProjectOption() {
        wizardWidget = widgetPage.clickWidgetType(TABLE);
        ConfigureWidget storyItemPage = wizardWidget.clickOpenStoryItem();
        storyItemPage.clickSaveConfigurationStoryItem();
    }

    /**
     * method deploy the iteration drop down list.
     */
    @When("^I deploy the iteration dropdown field$")
    public void iDeployTheIterationDropdownField() {
        wizardWidget = widgetPage.clickWidgetType(TABLE);
        wizardWidget.clickOpenStoryItem();
    }
}
