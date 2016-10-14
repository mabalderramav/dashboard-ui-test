package org.fundacionjala.dashboard.cucumber.hooks;

import cucumber.api.java.Before;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

/**
 * Class that instantiate the assertion according the requirements.
 */
public class AssertionHooks {

    private static Assertion assertion;

    /**
     * Instances a normal assert object.
     */
    @Before(order = 2)
    public void setUp() {
        assertion = new Assertion();
    }

    /**
     * Instances a soft assert object.
     */
    @Before(value = "@softAssert")
    public void setUpSoftAssert() {
        assertion = new SoftAssert();
    }

    /**
     * Returns the assertion instance.
     * @return The assertion instance.
     */
    public static Assertion getAssertion() {
        return assertion;
    }

}
