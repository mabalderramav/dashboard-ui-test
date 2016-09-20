package org.fundacionjala.dashboard.ui.page;

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
     * @param usernameObtained String whit the username
     */
    public final void setUsername(final String usernameObtained) {
        usernameTextField.clear();
        usernameTextField.sendKeys(usernameObtained);
    }

    /**
     * This method set the password in the text field.
     *
     * @param password String  whit the password
     */
    public final void setPasswordTextField(final String password) {
        passwordTextField.clear();
        passwordTextField.sendKeys(password);
    }

    /**
     * this method click the button.
     */
    public final void clickNextButton() {
        nextSigninButton.click();
    }

    /**
     * This method close the browser.
     */
    public final void clickClose() {
        getDriver().quit();
    }

}
