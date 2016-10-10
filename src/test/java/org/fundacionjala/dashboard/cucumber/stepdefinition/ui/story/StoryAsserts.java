package org.fundacionjala.dashboard.cucumber.stepdefinition.ui.story;

import java.util.List;
import java.util.Map;

import cucumber.api.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.TestCase;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebElement;

import org.fundacionjala.dashboard.cucumber.common.GlobalAsserts;
import org.fundacionjala.dashboard.cucumber.stepdefinition.api.ResourcesSteps;
import org.fundacionjala.dashboard.ui.pages.content.ConfigureWidget;
import org.fundacionjala.dashboard.ui.pages.content.widget.TableWidget;
import org.fundacionjala.dashboard.util.Utils;

import static org.junit.Assert.assertEquals;

/**
 * Class to manage Step definition  for table widget of Story features.
 */
public class StoryAsserts {
    private static final String CURRENT_ITERATION_NUMBER = "current_iteration_number";

    private ResourcesSteps resources;
    private List<WebElement> listProjects;
    private JSONArray obj;
    private static final String NAME = "name";
    private TableWidget tableWidget;

    /**
     * Constructor where initialize the values.
     *
     * @param newResources ResourcesStep.
     */
    public StoryAsserts(final ResourcesSteps newResources) {
        this.resources = newResources;
        tableWidget = new TableWidget();
    }


    /**
     * Method that calculate the projects quantity.
     *
     * @throws ParseException is and exception.
     */
    @Then("^Verify the projects quantity$")
    public void verifyTheProjectsQuantity() throws ParseException {
        obj = (JSONArray) new JSONParser().parse(resources.getResponseList()
                .get(resources.getResponseList().size() - 1).jsonPath().prettify());
        listProjects = new ConfigureWidget().clickProjectDropdownField();
        new ConfigureWidget().clickOut();
        assertEquals(listProjects.size(), obj.size());
    }

    /**
     * Method to Assert the displayed columns in the UI.
     *
     * @param projectName String  that is a name of the project.
     */
    @Then("^Verify the iterations quantity (.*)$")
    public void verifyTheIterationsQuantity(final String projectName) {
        ConfigureWidget configureWidget = new ConfigureWidget();
        configureWidget.clickIteration();
        JsonPath jsonPath = Utils.findElementJson(projectName, resources.getResponseList());
        new ConfigureWidget().clickOut();
        TestCase.assertEquals(configureWidget.getStoryIterationSize(), jsonPath.get(CURRENT_ITERATION_NUMBER));
    }

    /**
     * method to validate  all data of the story table whit pivotal tracker.
     * @param kind kind of Response it could be story or project.
     */
    @Then("^Validate (story|project) table against pivotal story$")
    public void allInformationOfPivotalTrackerStoryShouldBeDisplayedInStoryTableWidgetOfMach(final String kind) {
        List<Map<String, String>> tableProjectValues = tableWidget.getDataFromWidget();
        List<Response> responseList = resources.getResponseList();
        List<Map<String, String>> tableProjectValuesLowers = tableWidget.getConvertLowerCase(tableProjectValues);
        GlobalAsserts.executeListAssert(tableProjectValuesLowers, Utils.filterResponseByKind(responseList, kind));
    }
}
