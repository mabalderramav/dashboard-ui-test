package org.fundacionjala.dashboard.ui.pages;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.dashboard.ui.pages.menu.TopMenu;
import org.fundacionjala.dashboard.utils.Environment;

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
     * @param username String whit the username
     */
    public void setUsernameTextField(final String username) {
        usernameTextField.clear();
        usernameTextField.sendKeys(username);
    }

    /**
     * This method set the password in the text field.
     *
     * @param password String  whit the password
     */
    public void setPasswordTextField(final String password) {
        passwordTextField.clear();
        passwordTextField.sendKeys(password);
    }

    /**
     * this method click the button.
     */
    public HomePage clickNextButton() {
        nextSigninButton.click();
        return new HomePage();
    }

    public static void clickOnLogOut() {
        final TopMenu topMenu = new TopMenu();
        topMenu.clickUserMenu();
        topMenu.clickOnLogOut();
    }

    public static HomePage loginAs(String userName, String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.setUsernameTextField(userName);
        loginPage.setPasswordTextField(password);
        return loginPage.clickNextButton();
    }



//    public static HomePage loginAsPrimaryUser() {
//        return loginAs(Environment.getInstance().getPrimaryUser(), Environment.getInstance().getPrimaryPassword());
//    }

    public static HomePage loginAsPrimaryUser(){
        String userNameValue= Environment.getInstance().getPrimaryUser();
        String displayName= Environment.getInstance().getPrimaryDisplayName();
        String passwordValue=Environment.getInstance().getPrimaryPassword();
        HomePage homePage;

        try{
            homePage = new HomePage();
            TopMenu topMenu =  homePage.goToTopMenu();
            if(topMenu.isUserMenuPresent()){
                if(!topMenu.isUserLogged(displayName)){
                    LoginPage loginPage = topMenu.logout();
                    homePage = loginAs(userNameValue, passwordValue);
                }
            }

        }
        catch(WebDriverException e){
            homePage = loginAs(userNameValue, passwordValue);
        }
        return homePage;
    }

    public static HomePage loginAsSecondaryUser(){
        return loginAs(Environment.getInstance().getSecondaryUser(), Environment.getInstance().getSecondaryPassword());
    }


}
