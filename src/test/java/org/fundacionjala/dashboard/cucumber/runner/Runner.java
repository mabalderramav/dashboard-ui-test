package org.fundacionjala.dashboard.cucumber.runner;

import cucumber.api.CucumberOptions;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.fundacionjala.dashboard.ui.browser.DriverManager;
import org.testng.annotations.AfterClass;

/**
 * Class to execute all feature tests.
 */
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
public final class Runner extends AbstractTestNGCucumberTests {

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
