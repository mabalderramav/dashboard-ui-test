package org.fundacionjala.dashboard.cucumber.stepdefinition.ui.story;

import cucumber.api.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.TestCase;
import org.fundacionjala.dashboard.cucumber.stepdefinition.api.ResourcesSteps;
import org.fundacionjala.dashboard.ui.pages.content.ConfigureWidget;
import org.fundacionjala.dashboard.ui.pages.content.widget.TableWidget;
import org.fundacionjala.dashboard.util.Utils;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;
import java.util.Set;


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
        assertEquals(listProjects.size(), obj.size());
        new ConfigureWidget().clickOut();
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
        TestCase.assertEquals(configureWidget.getStoryIterationSize(), jsonPath.get(CURRENT_ITERATION_NUMBER));
        new ConfigureWidget().clickOut();
    }

    /**
     * method to validate  all data of the story table whit pivotal tracker.
     */
    @Then("^Validate story table against pivotal story$")
    public void allInformationOfPivotalTrackerStoryShouldBeDisplayedInStoryTableWidgetOfMach() {
        List<Map<String, String>> tableProjectValues = tableWidget.getDataFromWidget();
        List<Response> responseList = resources.getResponseList();
        List<Map<String, String>> tableProjectValuesLowers = tableWidget.getConvertLowerCase(tableProjectValues);
        executeListAssert(tableProjectValuesLowers, responseList);
    }

    /**
     * Method that given a list of data execute the assertions for each values of the response.
     *
     * @param widgetValues List of Map with the information of the displayed data in UI.
     * @param responseList List with that contain the responses.
     */
    public void executeListAssert(final List<Map<String, String>> widgetValues, final List<Response> responseList) {
        for (int i = 1; i < responseList.size(); i++) {
            JsonPath jsonPath = responseList.get(i).jsonPath();
            Map<String, String> row = Utils.findElementInArray(jsonPath.get(NAME), widgetValues);

            if (!row.isEmpty()) {
                executeAssert(row, jsonPath);
            }
        }
    }

    /**
     * Method to execute the asserts for each values of the response.
     *
     * @param map      Map with the information of the displayed data in UI.
     * @param jsonPath Json that contain the response.
     */
    public void executeAssert(final Map<String, String> map, final JsonPath jsonPath) {
        Map<String, String> strategyMap = Utils.mapStrategyWidgetStory(jsonPath);
        Set<String> keys = map.keySet();
        for (String key : keys) {
            assertEquals(map.get(key), strategyMap.get(key));
        }
    }


}
