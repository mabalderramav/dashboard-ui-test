package org.fundacionjala.dashboard.unitTest;

import org.fundacionjala.dashboard.ui.page.HomePage;
import org.fundacionjala.dashboard.ui.page.LoginPage;
import org.fundacionjala.dashboard.utility.Environment;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by brunovasquez on 9/21/2016.
 */
public class HomePageTest {

    private static final Environment ENVIRONMENT = Environment.getInstance();
    private HomePage homePage;
    @Before
    public final void testLogin() {
        final String userName = ENVIRONMENT.getUser();
        final String password = ENVIRONMENT.getPassword();
        LoginPage mainPageMach2 = new LoginPage();
       homePage = mainPageMach2.loginWithUser(userName, password);

    }
    /**
     * test for login in the application.
     */
    @Test
    public final void testHomePage() {

//        homePage.clickMenuBoard();
//        homePage.clickAddBoard();
//        homePage.changeBoardName("Hello baby");
       // mainPageMach2.clickClose();
    }
}
