package org.fundacionjala.dashboard.ui.browser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.fundacionjala.dashboard.utils.Environment;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * this class is to provide basic methods for manage the Selenium driver,
 * and initialize the logger main resources path.
 */
public final class DriverManager {

    private static final Environment ENVIRONMENT = Environment.getInstance();

    private static DriverManager instance;

    private WebDriver driver;

    private WebDriverWait wait;

    /**
     * This method is in charge to initialize the DriverManager.
     */
    private DriverManager() {
        final String baseUrl = ENVIRONMENT.getBaseUrl();
        final int timeout = ENVIRONMENT.getTimeout();
        final Browser browser = Browser.valueOf(ENVIRONMENT.getBrowser().toUpperCase());
        driver = DriverFactory.getDriver(browser).initDriver();
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        driver.get(baseUrl);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Environment.getInstance().getTimeout());
    }

    /**
     * This method Instance the instance if this does not exist.
     *
     * @return a instance.
     */
    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    /**
     * Get the webDriver specification.
     *
     * @return {@link WebDriver}.
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Get the wait specification.
     *
     * @return {@link WebDriverWait}.
     */
    public WebDriverWait getWait() {
        return wait;
    }
}
