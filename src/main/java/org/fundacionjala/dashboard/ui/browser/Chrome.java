package org.fundacionjala.dashboard.ui.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * This class initialize the Chrome Selenium Web Driver.
 */
public class Chrome implements IDriver {

    public static final String WEBDRIVER_DIRECTION = "WebDrivers\\chromedriver.exe";

    public static final String WEBDRIVER_KEY = "webdriver.chrome.driver";

    /**
     * {@inheritDoc}
     */
    @Override
    public final WebDriver initDriver() {
        System.setProperty(WEBDRIVER_KEY, WEBDRIVER_DIRECTION);
        return new ChromeDriver();
    }
}
