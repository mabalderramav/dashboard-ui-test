package org.fundacionjala.dashboard.ui.browser;

import org.openqa.selenium.WebDriver;

/**
 * This interface define the methods related to initialize the Selenium driver.
 */
public interface IDriver {

    /**
     * Initialize the Selenium web driver.
     *
     * @return {@link WebDriver}.
     */
    WebDriver initDriver();
}
