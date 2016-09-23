package org.fundacionjala.dashboard.ui.browser;

import org.openqa.selenium.WebDriverException;

/**
 * This class handle the logic related to what kind of browser.
 */
public final class DriverFactory {

    private static final String CHROME = "CHROME";

    private static final String FIREFOX = "FIREFOX";

    private static final String SAFARI = "SAFARI";

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
    public static IDriver getDriver(final String browser) {
        IDriver driver = null;
        if (CHROME.equalsIgnoreCase(browser)) {
            driver = new Chrome();
        } else if (SAFARI.equalsIgnoreCase(browser)) {
            driver = new Safari();
        } else {
            throw new WebDriverException("Not found");
        }
        return driver;
    }
}
