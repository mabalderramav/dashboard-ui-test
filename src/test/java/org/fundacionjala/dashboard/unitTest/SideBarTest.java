package org.fundacionjala.dashboard.unitTest;

import org.fundacionjala.dashboard.ui.page.*;
import org.fundacionjala.dashboard.utility.Environment;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by JimmyRomero on 9/23/2016.
 */
public class SideBarTest {
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
    public final void testNewGroupSideBarTest() {

        SideBar sideBar = homePage.goToSidebar();
        AddGroupPage addGroupPage = sideBar.clickAddGroupButton();
        addGroupPage.editGroupName("Baby");
    }

    /**
     * test for login in the application.
     */
    @Test
    public final void testNewBoardSideBarTest() {

        SideBar sideBar = homePage.goToSidebar();
        AddBoardPage addBoardPage = sideBar.clickAddBoardButton();
        addBoardPage.editBoardName("Board baby");
    }
}
