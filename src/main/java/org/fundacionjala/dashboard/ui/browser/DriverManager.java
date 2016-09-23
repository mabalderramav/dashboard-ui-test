package org.fundacionjala.dashboard.ui.browser;

import org.fundacionjala.dashboard.utility.Environment;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * this class is to provide basic methods for manage the Selenium driver,
 * and initialize the logger main resources path.
 */
public final class DriverManager {
    private static DriverManager driverManager;

    private static final Environment ENVIRONMENT = Environment.getInstance();

    private static final IDriver BROWSER =
            DriverFactory.getDriver(Browser.valueOf(ENVIRONMENT.getBrowser().toUpperCase()));

    private WebDriver driver;

    /**
     * This method is in charge to initialize the DriverManager.
     */
    private DriverManager() {
        final String baseUrl = ENVIRONMENT.getBaseUrl();
        final int timeout = ENVIRONMENT.getTimeout();
        driver = BROWSER.initDriver();
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    }

    /**
     * This method Instance the driverManager if this does not exist.
     *
     * @return a driverManager.
     */
    public static DriverManager getInstance() {
        if (driverManager == null) {
            driverManager = new DriverManager();
        }
        return driverManager;
    }

    /**
     * Get the webDriver specification.
     *
     * @return webDriver Specification.
     */
    public WebDriver getDriver() {
        return driver;
    }
}
