package org.fundacionjala.dashboard.cucumber.stepdefinition.ui.project;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cucumber.api.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.fundacionjala.dashboard.cucumber.stepdefinition.api.ResourcesSteps;
import org.fundacionjala.dashboard.cucumber.stepdefinition.ui.AssertTable;
import org.fundacionjala.dashboard.ui.pages.content.widget.InfoWidget;
import org.fundacionjala.dashboard.ui.pages.content.widget.TableWidget;
import org.fundacionjala.dashboard.ui.pages.content.widget.TypeWidget;
import org.fundacionjala.dashboard.util.Utils;
import org.fundacionjala.dashboard.utils.DataTimeManager;

import static org.fundacionjala.dashboard.cucumber.hooks.AssertionHooks.getAssertion;

/**
 * Class to manage Step definition  for table widget of features.project.
 */
public class ProjectAsserts {

    private static final String NAME = "name";
    private ResourcesSteps resources;
    private TableWidget tableWidget;

    /**
     * Constructor where initialize the values.
     *
     * @param newResources ResourcesStep.
     */
    public ProjectAsserts(final ResourcesSteps newResources) {
        this.resources = newResources;
        tableWidget = new TableWidget();
    }

    /**
     * Method to assert the pivotal tracker features.project with the Mach2 features.project tables.
     */
    @Then("^Validate project table against pivotal project")
    public void allInformationOfPivotalTrackerProjectsShouldBeDisplayedInProjectTableWidgetOfMach() {
        List<Map<String, String>> tableProjectValues = tableWidget.getDataFromWidget();
        List<Response> responseList = resources.getResponseList();
        executeListAssert(tableProjectValues, responseList);
    }

    /**
     * Method to Assert the obtained data from the UI against the Responses.
     */
    @Then("^All displayed projects should be the same that I sent in the request$")
    public void iExpectAllDisplayedProjectsInMachAreTheSameThatISentInTheRequest() {
        getAssertion().assertEquals(resources.getResponseList().size(), tableWidget.getDataFromWidget().size());
    }

    /**
     * Method to Assert the displayed columns in the UI.
     */
    @Then("^I expect the columns size should be the by default$")
    public void iExpectTheColumnsSizeShouldBe() {
        final int columnsByDefault = ProjectParameters.values().length;
        getAssertion().assertEquals(columnsByDefault, tableWidget.countDisplayedColumns());
    }

    /**
     * Method to Assert the displayed columns in the UI.
     */
    @Then("^Verify all information displayed in the widget$")
    public void verifyThatTheProjectNameIsTheSameThatTheProjectOnPivotalTracker() {
        TypeWidget<Map<String, String>> typeWidget = new InfoWidget();
        Map<String, String> list = typeWidget.getDataFromWidget();
        JsonPath jsonPath = Utils.findElementJson(list.get(NAME), resources.getResponseList());
        executeAssert(list, jsonPath);
    }

    /**
     * Method to validate content table against las response.
     */
    @Then("^Validate project table against last response pivotal project$")
    public void validateLastResponseFromPivotal() {
        List<Map<String, String>> tableProjectValues = tableWidget.getDataFromWidget();
        Response responseList = resources.getResponseList().get(resources.getResponseList().size() - 1);
        Map<String, String> row = Utils.findElementInArray(responseList.jsonPath().get(NAME), tableProjectValues);
        executeAssert(row, responseList.jsonPath());
    }

    /**
     * Method to validate if a table widget is empty.
     */
    @Then("^I expect an empty table project widget$")
    public void iExpectAnEmptyTableProjectWidget() {
        List<Map<String, String>> tableProjectValues = tableWidget.getDataFromWidget();
        getAssertion().assertTrue(tableProjectValues.isEmpty());
    }

    /**
     * Method that given a list of data execute the assertions for each values of the response.
     *
     * @param widgetValues List of Map with the information of the displayed data in UI.
     * @param responseList List with that contain the responses.
     */
    private void executeListAssert(final List<Map<String, String>> widgetValues,
                                   final List<Response> responseList) {
        for (int i = 0; i < responseList.size(); i++) {
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
    private void executeAssert(final Map<String, String> map, final JsonPath jsonPath) {
        Map<String, AssertTable> strategyMap = mapStrategyProjectWidget(jsonPath);
        Set<String> keys = map.keySet();
        for (String key : keys) {
            String expected = strategyMap.get(key).executeAssertion();
            getAssertion().assertEquals(map.get(key), expected);
        }
    }

    /**
     * Method to map the strategy to make the assertions.
     *
     * @param jsonPath the response values
     * @return the Map with the information to be validated.
     */
    private Map<String, AssertTable> mapStrategyProjectWidget(final JsonPath jsonPath) {
        Map<String, AssertTable> strategyMap = new HashMap<>();

        strategyMap.put(ProjectParameters.NAME.toString(), () -> jsonPath.get("name"));
        strategyMap.put(ProjectParameters.CURRENT_ITERATION.toString(),
                () -> jsonPath.get("current_iteration_number").toString());
        strategyMap.put(ProjectParameters.WEEK_START_DAY.toString(), () -> jsonPath.get("week_start_day"));
        strategyMap.put(ProjectParameters.CURRENT_VELOCITY.toString(),
                () -> jsonPath.get("initial_velocity").toString());
        strategyMap.put(ProjectParameters.ITERATION_LENGTH.toString(),
                () -> jsonPath.get("iteration_length").toString());
        strategyMap.put(ProjectParameters.POINT_SCALE.toString(), () -> jsonPath.get("point_scale"));
        strategyMap.put(ProjectParameters.INITIAL_VELOCITY.toString(),
                () -> jsonPath.get("initial_velocity").toString());
        strategyMap.put(ProjectParameters.PROJECT_STARTED_AT.toString(),
                () -> DataTimeManager.parserDataTimeToFirstFormat(jsonPath.get("start_date").toString()));

        return strategyMap;
    }
}
