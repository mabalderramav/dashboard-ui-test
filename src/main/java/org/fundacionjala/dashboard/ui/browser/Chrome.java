package org.fundacionjala.dashboard.ui.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * This class initialize the Chrome Selenium Web Driver.
 */
public class Chrome implements IDriver {
    /**
     * {@inheritDoc}
     */
    @Override
    public final WebDriver initDriver() {
        return new ChromeDriver();
    }
}
