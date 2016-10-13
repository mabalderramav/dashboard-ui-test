package org.fundacionjala.dashboard.cucumber.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import org.fundacionjala.dashboard.ui.pages.AbstractBasePage;

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
public class Runner extends AbstractBasePage {

    /**
     * Method to Close the driver after the execution.
     */
    @AfterClass
    public static void tearDown() {
        AbstractBasePage.driver.quit();
    }
}
