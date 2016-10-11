package org.fundacionjala.dashboard.cucumber.hooks;

import cucumber.api.java.Before;

import org.fundacionjala.dashboard.ui.pages.HomePage;
import org.fundacionjala.dashboard.ui.pages.LoginPage;

/**
 * Class to initialize session.
 */
public class LoginHook {

    private static boolean beforeAllFlag;

    /**
     * Method to Login with the default user.
     */
    @Before (order = 1)
    public void beforeAll() {
        if (!beforeAllFlag) {
            // Login as Primary
            HomePage homePage = LoginPage.loginAsPrimaryUser();
            homePage.goToTopMenu();

            beforeAllFlag = true;
        }
    }
}
