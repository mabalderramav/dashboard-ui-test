package org.fundacionjala.dashboard.cucumber.stepdefinition.ui.project;

import java.util.List;
import java.util.Map;

import cucumber.api.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.fundacionjala.dashboard.cucumber.common.GlobalAsserts;
import org.fundacionjala.dashboard.cucumber.stepdefinition.api.ResourcesSteps;
import org.fundacionjala.dashboard.ui.pages.content.widget.InfoWidget;
import org.fundacionjala.dashboard.ui.pages.content.widget.TableWidget;
import org.fundacionjala.dashboard.ui.pages.content.widget.TypeWidget;
import org.fundacionjala.dashboard.util.Utils;

import static org.junit.Assert.assertEquals;


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
        GlobalAsserts.executeListAssert(tableProjectValues, responseList);
    }

    /**
     * Method to Assert the obtained data from the UI against the Responses.
     */
    @Then("^All displayed projects should be the same that I sent in the request$")
    public void iExpectAllDisplayedProjectsInMachAreTheSameThatISentInTheRequest() {
        assertEquals(resources.getResponseList().size(), tableWidget.getDataFromWidget().size());
    }

    /**
     * Method to Assert the displayed columns in the UI.
     */
    @Then("^I expect the columns size should be the by default$")
    public void iExpectTheColumnsSizeShouldBe() {
        final int columnsByDefault = ProjectParameters.values().length;
        assertEquals(columnsByDefault, tableWidget.countDisplayedColumns());
    }

    /**
     * Method to Assert the displayed columns in the UI.
     */
    @Then("^Verify all information displayed in the widget$")
    public void verifyThatTheProjectNameIsTheSameThatTheProjectOnPivotalTracker() {
        TypeWidget<Map<String, String>> typeWidget = new InfoWidget();
        Map<String, String> list = typeWidget.getDataFromWidget();
        JsonPath jsonPath = Utils.findElementJson(list.get(NAME), resources.getResponseList());
        GlobalAsserts.executeAssert(list, jsonPath);
    }
}
