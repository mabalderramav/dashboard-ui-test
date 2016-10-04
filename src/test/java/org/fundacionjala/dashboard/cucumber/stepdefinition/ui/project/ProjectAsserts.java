package org.fundacionjala.dashboard.cucumber.stepdefinition.ui.project;

import java.util.List;
import java.util.Map;
import java.util.Set;

import cucumber.api.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.fundacionjala.dashboard.cucumber.stepdefinition.api.ResourcesSteps;
import org.fundacionjala.dashboard.ui.pages.content.widget.TableWidget;
import org.fundacionjala.dashboard.util.Utils;

import static org.junit.Assert.assertEquals;


/**
 * Class to manage Step definition  for table widget of features.project.
 */
public class ProjectAsserts {

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
    @Then("^Validate project table against pivotal project$")
    public void allInformationOfPivotalTrackerProjectsShouldBeDisplayedInProjectTableWidgetOfMach() {
        List<Map<String, String>> tableProjectValues = tableWidget.getDataFromWidget();
        List<Response> responseList = resources.getResponseList();
        executeAsserts(tableProjectValues, responseList);
    }

    /**
     * Method to execute the asserts for each values of the response.
     *
     * @param tableProjectValues List of Map with the information of the displayed data in UI.
     * @param responseList       List with that contain the responses.
     */
    private void executeAsserts(final List<Map<String, String>> tableProjectValues, final List<Response> responseList) {
        for (int i = 0; i < responseList.size(); i++) {
            JsonPath jsonPath = responseList.get(i).jsonPath();
            Map<String, String> row = Utils.findElementInArray(jsonPath.get("name"), tableProjectValues);

            if (!row.isEmpty()) {
                Map<String, String> strategyMap = Utils.mapStrategyWidget(jsonPath);

                Set<String> keys = strategyMap.keySet();
                for (String key : keys) {
                    assertEquals(row.get(key), strategyMap.get(key));
                }
            }
        }

    }

    /**
     * Method to Assert the obtained data from the UI against the Responses.
     */
    @Then("^I expect all displayed projects in Mach2 are the same that I sent in the request\\.$")
    public void iExpectAllDisplayedProjectsInMachAreTheSameThatISentInTheRequest() {
        assertEquals(resources.getResponseList().size(), tableWidget.getDataFromWidget().size());
    }

    /**
     * Method to Assert the displayed columns in the UI.
     *
     * @param columnsSize expected Column.
     */
    @Then("^I expect the columns size should be (\\d+)$")
    public void iExpectTheColumnsSizeShouldBe(final int columnsSize) {
        assertEquals(columnsSize, tableWidget.countDisplayedColumns());
    }
}
