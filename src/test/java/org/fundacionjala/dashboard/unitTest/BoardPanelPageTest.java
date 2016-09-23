package org.fundacionjala.dashboard.unitTest;

import org.fundacionjala.dashboard.ui.page.BoardPage;
import org.fundacionjala.dashboard.ui.page.HomePage;
import org.fundacionjala.dashboard.ui.page.LoginPage;
import org.fundacionjala.dashboard.ui.page.TopMenu;
import org.fundacionjala.dashboard.utility.Environment;
import org.junit.Before;
import org.junit.Test;

public class BoardPanelPageTest {

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
    public final void testBoardPage() {

//        homePage.clickMenuBoard();
//        homePage.clickAddBoard();

        TopMenu topMenu = homePage.goToTopMenu();
        topMenu.clickMenuBoard();
        BoardPage boardPage=topMenu.clickAddBoardMenu();
        boardPage.changeBoardName("Hello baby");
    }
}
