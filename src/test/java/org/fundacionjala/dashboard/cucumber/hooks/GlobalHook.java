package org.fundacionjala.dashboard.cucumber.hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.fundacionjala.dashboard.ui.browser.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/**
 * Takes screenshot per scenario executed.
 */
public class GlobalHook {
    /**
     * Takes a screenshot after the scenario failed.
     *
     * @param scenario The current scenario.
     */
    @After
    public void tearDown(final Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) DriverManager.getInstance().getDriver())
                    .getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
    }
}
