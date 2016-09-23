package org.fundacionjala.dashboard.unitTest;

import org.fundacionjala.dashboard.ui.page.HomePage;
import org.fundacionjala.dashboard.ui.page.LoginPage;
import org.fundacionjala.dashboard.utility.Environment;
import org.junit.Test;

/**
 * Test for {@link }.
 */
public class LoginTest {

    private static final Environment ENVIRONMENT = Environment.getInstance();

    /**
     * test for login in the application.
     */
    @Test
    public final void testLogin() {
        final String userName = ENVIRONMENT.getUser();
        final String password = ENVIRONMENT.getPassword();
        LoginPage mainPageMach2 = new LoginPage();
        HomePage homePage = mainPageMach2.loginWithUser(userName, password);

    }
}
