package org.fundacionjala.dashboard.ui.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * This class initialize the Safari Selenium Web Driver.
 */
public class Safari implements IDriver {

    /**
     * {@inheritDoc}
     */
    @Override
    public final WebDriver initDriver() {
        return new SafariDriver();
    }
}
