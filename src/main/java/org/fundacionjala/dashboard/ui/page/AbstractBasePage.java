package org.fundacionjala.dashboard.ui.page;

import org.fundacionjala.dashboard.ui.browser.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This base page abstract class.
 */
public abstract class AbstractBasePage {

    private WebDriver driver;
    private WebDriverWait wait;

    /**
     * This builds initialize the AbstractBasePage.
     */
    public AbstractBasePage() {
        driver = DriverManager.getInstance().getDriver();
        wait = new WebDriverWait(driver,60);
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
