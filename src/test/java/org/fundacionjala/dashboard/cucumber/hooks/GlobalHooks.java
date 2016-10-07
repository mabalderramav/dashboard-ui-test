package org.fundacionjala.dashboard.cucumber.hooks;

import cucumber.api.java.Before;
import org.fundacionjala.dashboard.ui.pages.HomePage;
import org.fundacionjala.dashboard.ui.pages.LoginPage;

/**
 * This class stores the global hooks methods required to run the test
 */
public class GlobalHooks {
    private static boolean beforeAllFlag;

    /**
     * Method to login with user by default.
     */
    @Before
    public void beforeAll() {
        if (!beforeAllFlag) {
            // Login as Primary
            HomePage homePage = LoginPage.loginAsPrimaryUser();
            beforeAllFlag = true;
        }
    }
}
