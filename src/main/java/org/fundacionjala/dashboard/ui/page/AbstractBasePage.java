package org.fundacionjala.dashboard.ui.page;

import org.fundacionjala.dashboard.ui.browser.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * This base page abstract class.
 */
public abstract class AbstractBasePage {

    private WebDriver driver;

    /**
     * This builds initialize the AbstractBasePage.
     */
    public AbstractBasePage() {
        driver = DriverManager.getInstance().getDriver();
        PageFactory.initElements(driver, this);
    }

    /**
     * this methos return the driver.
     *
     * @return Webdriver.
     */
    protected final WebDriver getDriver() {
        return driver;
    }
}
