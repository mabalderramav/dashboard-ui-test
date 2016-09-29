package org.fundacionjala.dashboard.unittest;

import org.fundacionjala.dashboard.ui.pages.HomePage;


import org.fundacionjala.dashboard.ui.pages.LoginPage;
import org.fundacionjala.dashboard.ui.pages.menu.TopMenu;
import org.fundacionjala.dashboard.utils.Environment;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class LoginTest {
    HomePage homePage;

    LoginPage loginPage;
    TopMenu topMenu;


    @Before
    public void setUp(){

        homePage = LoginPage.loginAsPrimaryUser();
        topMenu = homePage.goToTopMenu();
        topMenu.clickUserMenu();
        topMenu.clickOnLogOut();

    }
    @Test
    public void Login(){
        String account = Environment.getInstance().getPrimaryUser();
        String password = Environment.getInstance().getPrimaryPassword();
        String displayName=Environment.getInstance().getPrimaryDisplayName();
        loginPage = new LoginPage();
        loginPage.setUsernameTextField(account);
        loginPage.setPasswordTextField(password);
        homePage=loginPage.clickNextButton();
        topMenu =homePage.goToTopMenu();
        Assert.assertEquals(topMenu.getUserName(),displayName);
    }

}