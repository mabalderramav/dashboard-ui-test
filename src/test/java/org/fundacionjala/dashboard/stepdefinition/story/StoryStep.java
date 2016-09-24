package org.fundacionjala.dashboard.stepdefinition.story;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.dashboard.stepdefinition.api.ResourcesSteps;
import org.fundacionjala.dashboard.ui.page.*;

import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by juanarodriguez on 9/23/2016.
 */
public class StoryStep {
    private HomePage homePage;
    private ResourcesSteps resources;
    private WidgetPage widgetPage;
    Map<String, String> tableStoryValues;
    private ServiceForm serviceForm;
    /**
     * Method to add a table widget for creating a Story Item.
     */
    @Given("^I add a table widget in the board$")
    public final void iAddATableWidgetInTheBoard() {
        TopMenu topMenu = homePage.goToTopMenu();
        BoardPage boardPage = topMenu.clickAddBoardMenu();

        WidgetPage widgetPage = boardPage.clickAddWidgetMenu();
        serviceForm = widgetPage.clickTableWidgetType();
    }

    /**
     * Method to Select the Story Items option form the UI.
     */
    @When("^I select Story Items option$")
    public final void iSelectTheProjectOption() {
        serviceForm = widgetPage.clickTableWidgetType();
        StoryItemPage storyItemPage = serviceForm.clickOpenStoryItem();
        StoryItemTable storyItemTable = storyItemPage.clickSaveConfigurationStoryItem();
        tableStoryValues = storyItemTable.getStoryTable();
    }

    /**
     * Method to assert the pivotal tracker stories with the Mach2 stories tables.
     */
    @Then("^All information of Pivotal Tracker stories should be displayed in story table widget of Mach2(\\d+)$")
    public final void allInformationOfPivotalTrackerprojectsShouldBeDisplayedInProjectTableWidgetOfMach() {
        assertEquals(tableStoryValues.get("name"), resources.getResponse().jsonPath().get("name"));
        assertEquals(tableStoryValues.get("current_state"),
                resources.getResponse().jsonPath().get("current_state"));
        assertEquals(tableStoryValues.get("estimate"),
                resources.getResponse().jsonPath().get("estimate"));
        assertEquals(tableStoryValues.get("story_type"),
                resources.getResponse().jsonPath().get("story_type"));
    }
}
