package org.fundacionjala.dashboard.cucumber.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import org.fundacionjala.dashboard.ui.browser.DriverManager;

/**
 * Class to execute all feature tests.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        format = {"pretty",
                "html:target/test-report",
                "json:target/test-report.json",
                "junit:target/test-report.xml"
        },
        features = {
                "src/test/resources/"
        },
        glue = {
                "org.fundacionjala.dashboard.cucumber"
        }
)
public final class Runner {

    /**
     * Private constructor.
     */
    private Runner() {

    }

    /**
     * Method to Close the driver after the execution.
     */
    @AfterClass
    public static void tearDown() {
        DriverManager.getInstance().getDriver().quit();
    }
}
