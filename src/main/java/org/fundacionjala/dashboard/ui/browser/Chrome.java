package org.fundacionjala.dashboard.ui.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * This class initialize the Chrome Selenium Web Driver.
 */
public class Chrome implements IDriver {

    private static final String WEBDRIVER_DIRECTION = "webdrivers/chromedriver.exe";

    private static final String WEBDRIVER_KEY = "webdriver.chrome.driver";

    /**
     * {@inheritDoc}
     */
    @Override
    public final WebDriver initDriver() {
        System.setProperty(WEBDRIVER_KEY, WEBDRIVER_DIRECTION);
        return new ChromeDriver();
    }
}
