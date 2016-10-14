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
     * @param scenario
     */
    @After(order = 10)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) DriverManager.getInstance().getDriver())
                    .getScreenshotAs(OutputType.BYTES);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            scenario.embed(screenshot, "image/png");
        }
    }
}
