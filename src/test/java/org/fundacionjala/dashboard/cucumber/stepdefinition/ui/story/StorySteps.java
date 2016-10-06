package org.fundacionjala.dashboard.cucumber.stepdefinition.ui.story;

import java.util.Map;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.dashboard.cucumber.stepdefinition.api.ResourcesSteps;
import org.fundacionjala.dashboard.ui.pages.content.ConfigureWidget;
import org.fundacionjala.dashboard.ui.pages.content.StoryItemTable;
import org.fundacionjala.dashboard.ui.pages.content.widget.WidgetPage;
import org.fundacionjala.dashboard.ui.pages.content.widget.WizardWidget;

import static org.fundacionjala.dashboard.ui.pages.content.widget.Widget.TABLE;
import static org.junit.Assert.assertEquals;

/**
 * Created by juanarodriguez on 9/23/2016.
 */
public class StorySteps {
    private ResourcesSteps resources;
    private WidgetPage widgetPage;
    private Map<String, String> tableStoryValues;
    private WizardWidget wizardWidget;

    /**
     * Method to Select the Story Items option form the UI.
     */
    @When("^I select Story Items option$")
    public void iSelectTheProjectOption() {
        wizardWidget = widgetPage.clickWidgetType(TABLE);
        ConfigureWidget storyItemPage = wizardWidget.clickOpenStoryItem();
        StoryItemTable storyItemTable = storyItemPage.clickSaveConfigurationStoryItem();
        tableStoryValues = storyItemTable.getStoryTable();
    }

    /**
     * Method to assert the pivotal tracker stories with the Mach2 stories tables.
     */
    @Then("^All information of Pivotal Tracker stories should be displayed in story table widget of Mach2$")
    public void allInformationOfPivotalTrackerprojectsShouldBeDisplayedInProjectTableWidgetOfMach() {
        assertEquals(tableStoryValues.get("name"), resources.getResponseList().get(0).jsonPath().get("name"));
        assertEquals(tableStoryValues.get("current_state"),
                resources.getResponseList().get(0).jsonPath().get("current_state"));
        assertEquals(tableStoryValues.get("estimate"),
                resources.getResponseList().get(0).jsonPath().get("estimate"));
        assertEquals(tableStoryValues.get("story_type"),
                resources.getResponseList().get(0).jsonPath().get("story_type"));
    }
}
