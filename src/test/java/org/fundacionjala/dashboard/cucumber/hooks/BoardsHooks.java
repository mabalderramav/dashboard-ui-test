package org.fundacionjala.dashboard.cucumber.hooks;

import cucumber.api.java.Before;
import org.fundacionjala.dashboard.ui.pages.content.MyDashboard;
import org.fundacionjala.dashboard.ui.pages.menu.TopMenu;
import org.fundacionjala.dashboard.ui.pages.sidebar.SideBar;

/**
 * This class delete all Boards on Mach2.
 */
public class BoardsHooks {
    /**
     * Method that delete all the existent boards on MACH2.
     */
    @Before(value = "@deleteAllBoards", order = 2)
    public void deleteAllBoards() {
        SideBar sideBar = new TopMenu().clickGeneralMenu();
        MyDashboard myDashboard = sideBar.clickMyDashBoardButton();
        myDashboard.deleteAllBoards();
        myDashboard.clickInTheRigthSideOfPage();

    }
}
