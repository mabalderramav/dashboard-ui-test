package org.fundacionjala.dashboard.cucumber.stepdefinition.global;

import cucumber.api.java.en.Then;
import org.testng.asserts.SoftAssert;

import static org.fundacionjala.dashboard.cucumber.hooks.AssertionHooks.getAssertion;

/**
 * Class that contains global steps.
 */
public class CommonSteps {


    /**
     * Executes all the assertions that are instance of soft assert.
     */
    @Then("^Consolidate all soft assert results$")
    public void tearDownSoftAssert() {
        if (getAssertion() instanceof SoftAssert) {
            ((SoftAssert) getAssertion()).assertAll();
        }
    }
}
