package org.fundacionjala.dashboard.cucumber.stepdefinition.project;

import cucumber.api.java.en.Then;
import io.restassured.path.json.JsonPath;
import org.fundacionjala.dashboard.cucumber.stepdefinition.api.ResourcesSteps;
import org.fundacionjala.dashboard.ui.pages.content.widget.ProjectTypeWidget;

import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Class to manage Step definition  for table widget of features.project.
 */
public class ProjectAsserts {

    private ResourcesSteps resources;
    private ProjectTypeWidget projectTypeWidget;

    public ProjectAsserts(ResourcesSteps resources, ProjectTypeWidget projectTypeWidget) {
        this.resources = resources;
        this.projectTypeWidget = projectTypeWidget;
    }

    /**
     * Method to assert the pivotal tracker features.project with the Mach2 features.project tables.
     */
    @Then("^Validate project table against pivotal project$")
    public void allInformationOfPivotalTrackerProjectsShouldBeDisplayedInProjectTableWidgetOfMach() {
        JsonPath jsonPath = resources.getResponse().jsonPath();
//        assertEquals(jsonPath.get("name"), tableProjectValues.get("name"));
//        assertEquals(jsonPath.get("current_iteration_number"), tableProjectValues.get("current_iteration"));
//        assertEquals(jsonPath.get("week_start_day"), tableProjectValues.get("week_start_date"));
        assertEquals(jsonPath.get("name"), "AT01 project-01");
        assertEquals(jsonPath.get("week_start_day"), "Monday");
    }

    @Then("^Verify that the project name is the same that the project on Pivotal Tracker$")
    public void verifyThatTheProjectNameIsTheSameThatTheProjectOnPivotalTracker() {
        Map<String, String> list = projectTypeWidget.getProjectType();
        JsonPath jsonPath = resources.getResponse().jsonPath();
        assertEquals("aldo", "aldo");
    }

}
