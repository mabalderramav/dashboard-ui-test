package org.fundacionjala.dashboard.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.fundacionjala.dashboard.ui.browser.DriverManager;
import org.fundacionjala.dashboard.utils.Environment;

/**
 * This base page abstract class.
 */
public abstract class AbstractBasePage {

    protected WebDriver driver;

    protected WebDriverWait wait;

    /**
     * This builds initialize the AbstractBasePage.
     */
    public AbstractBasePage() {
        driver = DriverManager.getInstance().getDriver();
        wait = new WebDriverWait(driver, Environment.getInstance().getTimeout());
        PageFactory.initElements(driver, this);
    }

}
