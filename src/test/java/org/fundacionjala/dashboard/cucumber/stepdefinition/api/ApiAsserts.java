package org.fundacionjala.dashboard.cucumber.stepdefinition.api;

import cucumber.api.java.en.Then;

import static junit.framework.TestCase.assertEquals;

/**
 * This class is in charge to manage the asserts for all steps definitions.
 */
public class ApiAsserts {

    private final ResourcesSteps resourcesSteps;

    /**
     * Initialize the resources steps.
     *
     * @param resourcesStep resources steps.
     */
    public ApiAsserts(final ResourcesSteps resourcesStep) {
        resourcesSteps = resourcesStep;
    }

    /**
     * Method to validate the status code of the response.
     *
     * @param statusCode the status code expected.
     */
    @Then("^I expect the status code (\\d+)$")
    public void iExpectStatusCode(final int statusCode) {
        assertEquals(statusCode, resourcesSteps.getResponse().getStatusCode());
    }
}
