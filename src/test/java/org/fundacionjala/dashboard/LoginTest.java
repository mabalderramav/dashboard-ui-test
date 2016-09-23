package org.fundacionjala.dashboard;

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
        mainPageMach2.setUsername(userName);
        mainPageMach2.setPasswordTextField(password);
        mainPageMach2.clickNextButton();
        //mainPageMach2.clickClose();
    }
}
