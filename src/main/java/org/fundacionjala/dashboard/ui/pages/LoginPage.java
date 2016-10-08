package org.fundacionjala.dashboard.ui.pages;

import org.fundacionjala.dashboard.ui.browser.DriverManager;
import org.fundacionjala.dashboard.ui.pages.menu.TopMenu;
import org.fundacionjala.dashboard.utils.Environment;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * This class set  the user name and password in the main page and login.
 */
public class LoginPage extends AbstractBasePage {

    @FindBy(name = "username")
    private WebElement usernameTextField;

    @FindBy(name = "password")
    private WebElement passwordTextField;

    @FindBy(css = "button.ui.right.floated.blue.submit.button")
    private WebElement nextSigninButton;

    /**
     * This method set the username in the text field.
     *
     * @param username String whit the username.
     */
    public void setUsernameTextField(final String username) {
        usernameTextField.clear();
        usernameTextField.sendKeys(username);
    }

    /**
     * This method set the password in the text field.
     *
     * @param password String  whit the password.
     */
    public void setPasswordTextField(final String password) {
        passwordTextField.clear();
        passwordTextField.sendKeys(password);
    }

    /**
     * Method to click on next button.
     *
     * @return The home page.
     */
    public HomePage clickNextButton() {
        nextSigninButton.click();
        return new HomePage();
    }

    /**
     * Method to perform a Logout from Mach2 application.
     */
    public static void clickOnLogOut() {
        final TopMenu topMenu = new TopMenu();
        topMenu.clickUserMenu();
        topMenu.clickOnLogOut();
    }

    /**
     * Method used to perform a login to Mach2 application.
     *
     * @param userName Username used to perform a login to Mach2 application.
     * @param password Password used to perform a login to Mach2 application.
     * @return The login to Mach2 application.
     */
    public static HomePage loginAs(final String userName, final String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.setUsernameTextField(userName);
        loginPage.setPasswordTextField(password);
        return loginPage.clickNextButton();
    }

    /**
     * Method to perform a login with other user.
     *
     * @param userName Username to perform a login with other user.
     * @param password Password to perform a login with other user.
     * @return The login to Mach2 application.
     */
    public static HomePage loginOtherUser(final String userName, final String password) {
        HomePage homePage;
        try {
            homePage = new HomePage();
            TopMenu topMenu = homePage.goToTopMenu();
            if (!topMenu.isUserLogged(topMenu.getUserName())) {
                LoginPage loginPage = topMenu.logout();
                homePage = loginAs(userName, password);
            }
        } catch (WebDriverException e) {
            DriverManager.getInstance().getDriver().get(Environment.getInstance().getBaseUrl());
            homePage = loginAs(userName, password);
        }
        return homePage;
    }

    /**
     * Method to perform a login as Primary user.
     *
     * @return Login to Mach2 application.
     */
    public static HomePage loginAsPrimaryUser() {
        String userNameValue = Environment.getInstance().getPrimaryUser();
        String passwordValue = Environment.getInstance().getPrimaryPassword();
        return loginOtherUser(userNameValue, passwordValue);
    }
}
