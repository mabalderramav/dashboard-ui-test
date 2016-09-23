package org.fundacionjala.dashboard.ui.browser;

import org.openqa.selenium.WebDriverException;

/**
 * This class handle the logic related to what kind of browser.
 */
public final class DriverFactory {

    /**
     * Private constructor.
     */
    private DriverFactory() {
    }

    /**
     * Get Driver to what kind of browser.
     *
     * @param browser kind of driver to return.
     * @return Kind of driver Browser.
     */
    public static IDriver getDriver(final Browser browser) {
        switch (browser) {
            case CHROME:
                return new Chrome();
            case SAFARI:
                return new Safari();
            default:
                throw new WebDriverException("Browser not found.");
        }
    }
}
