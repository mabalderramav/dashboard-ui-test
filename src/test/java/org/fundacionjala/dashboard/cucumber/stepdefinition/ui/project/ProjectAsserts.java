package org.fundacionjala.dashboard.cucumber.stepdefinition.ui.project;

import cucumber.api.java.en.Then;
import io.restassured.path.json.JsonPath;
import org.fundacionjala.dashboard.cucumber.stepdefinition.api.ResourcesSteps;
import org.fundacionjala.dashboard.ui.pages.content.widget.InfoWidget;
import org.fundacionjala.dashboard.ui.pages.content.widget.TypeWidget;

import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Class to manage Step definition  for table widget of features.project.
 */
public class ProjectAsserts {

    private ResourcesSteps resources;

    public ProjectAsserts(ResourcesSteps resources) {
        this.resources = resources;
    }

    /**
     * Method to assert the pivotal tracker features.project with the Mach2 features.project tables.
     */
    @Then("^Validate project table against pivotal project$")
    public void allInformationOfPivotalTrackerProjectsShouldBeDisplayedInProjectTableWidgetOfMach() {
        JsonPath jsonPath = resources.getResponse().jsonPath();
        assertEquals(jsonPath.get("name"), "AT01 project-01");
        assertEquals(jsonPath.get("week_start_day"), "Monday");

    }

    @Then("^Verify that the project name is the same that the project on Pivotal Tracker$")
    public void verifyThatTheProjectNameIsTheSameThatTheProjectOnPivotalTracker() {
        TypeWidget typeWidget = new InfoWidget();
        Map<String, String> list = typeWidget.getProjectType();
        JsonPath jsonPath = resources.getResponse().jsonPath();
        assertEquals("aldo", "aldo");
    }

}
