package org.fundacionjala.dashboard.unitTest;

import org.fundacionjala.dashboard.ui.page.*;
import org.fundacionjala.dashboard.utility.Environment;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by brunovasquez on 9/23/2016.
 */
public class StoryItemTableTest {

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
        TopMenu topMenu = homePage.goToTopMenu();
        BoardPage boardPage = topMenu.clickAddBoardMenu();

        WidgetPage widgetPage = boardPage.clickAddWidgetMenu();
        ServiceForm serviceForm = widgetPage.clickTableWidgetType();
        StoryItemPage storyItemPage = serviceForm.clickOpenStoryItem();
        storyItemPage.autoCompleteProject("MT/AT 01");
        StoryItemTable storyItemTable = storyItemPage.clickSaveConfigurationStoryItem();
        storyItemTable.getStoryTable();
    }
}
