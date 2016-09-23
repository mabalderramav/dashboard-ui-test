package org.fundacionjala.dashboard;

import org.fundacionjala.dashboard.ui.page.*;
import org.fundacionjala.dashboard.ui.page.projectwidget.ConfigTableProject;
import org.fundacionjala.dashboard.ui.page.projectwidget.ProjectTableWidget;
import org.fundacionjala.dashboard.utility.Environment;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by ErickaViraca on 9/23/2016.
 */
public class ProjectTest {

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
    public final void testProject() {
        homePage.clickMenuBoard();
        BoardPanelPage boardPanelPage = homePage.clickAddBoard();
        boardPanelPage.clickAddBoard();
        WidgetPage widgetPage = new WidgetPage();
        ServiceForm serviceForm = widgetPage.clickOpenTable();
        ConfigTableProject configTableForm = serviceForm.clickOpenProject();
        ProjectTableWidget projectTableWidget = configTableForm.clickSaveConfigurationProject();
        projectTableWidget.getProjectTable();
    }
}
