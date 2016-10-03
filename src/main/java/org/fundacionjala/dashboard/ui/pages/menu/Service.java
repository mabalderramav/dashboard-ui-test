package org.fundacionjala.dashboard.ui.pages.menu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.fundacionjala.dashboard.ui.pages.AbstractBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * This class is in charge to handle services.
 */
public class Service extends AbstractBasePage {

    @FindBy(css = "div.ui.selection.dropdown")
    private WebElement dropDownListOfServices;

    @FindBy(css = "input[name='token']")
    private WebElement tokenTextField;

    @FindBy(name = "description")
    private WebElement descriptionTextField;

    @FindBy(css = "div.ui.shadowless.top.sidebar.overlay.visible button.ui.right.floated.blue.submit.button")
    private WebElement saveButton;

    @FindBy(name = "serverAddress")
    private WebElement serverAddressTextField;

    @FindBy(name = "userName")
    private WebElement userNameTextField;

    @FindBy(name = "host")
    private WebElement hostTextField;

    @FindBy(name = "port")
    private WebElement portTextField;

    @FindBy(name = "userPassword")
    private WebElement userPasswordTextField;

    @FindBy(name = "apiBaseUrl")
    private WebElement apiBaseUrlTextField;

    @FindBy(name = "database")
    private WebElement dataBaseTextField;

    @FindBy(name = "password")
    private WebElement passwordTextField;

    @FindBy(name = "user")
    private WebElement userTextField;

    @FindBy(css = "div.ui.stackable.three.column.grid")
    private WebElement columnServices;

    /**
     * this method deploy the drop down list  to add services.
     *
     * @param serviceName String thats the name of the service.
     */
    public void selectServiceDropdown(final String serviceName) {
        dropDownListOfServices.click();
        driver.findElement(By.xpath("//div[@class='menu transition visible']/div[text()='" + serviceName + "']"))
                .click();
    }

    /**
     * Set the token text field.
     *
     * @param token String that's the token.
     */
    public void setTokenTextField(final String token) {
        tokenTextField.clear();
        tokenTextField.sendKeys(token);
    }

    /**
     * Set the description text field.
     *
     * @param description String that's the description.
     */
    public void setDescriptionTextField(final String description) {
        descriptionTextField.clear();
        descriptionTextField.sendKeys(description);
    }

    /**
     * Click on the button save.
     *
     * @return profile page.
     */
    public Profile clickSaveButton() {
        saveButton.click();
        driver.navigate().refresh();
        return new Profile();
    }

    /**
     * Set the user name text field.
     *
     * @param userName String that's the user name.
     */
    public void setUserNameTextField(final String userName) {
        userNameTextField.clear();
        userNameTextField.sendKeys(userName);
    }

    /**
     * Set the user password text field.
     *
     * @param password String that's the password text.
     */
    public void setUserPasswordTextFieldTextField(final String password) {
        userPasswordTextField.clear();
        userPasswordTextField.sendKeys(password);
    }

    /**
     * Set the url text field.
     *
     * @param apiBaseUrl String that's the url text.
     */
    public void setApiBaseUrlTextField(final String apiBaseUrl) {
        apiBaseUrlTextField.clear();
        apiBaseUrlTextField.sendKeys(apiBaseUrl);
    }

    /**
     * Set the server Address text field.
     *
     * @param apiBaseUrl String that's the url text.
     */
    public void setServerAddressTextField(final String apiBaseUrl) {
        serverAddressTextField.clear();
        serverAddressTextField.sendKeys(apiBaseUrl);
    }

    /**
     * Set the Host text field.
     *
     * @param host String that's the host text.
     */
    public void setHostTextField(final String host) {
        hostTextField.clear();
        hostTextField.sendKeys(host);
    }

    /**
     * Set the Port text field.
     *
     * @param port String that's the port text.
     */
    public void setPortTextField(final String port) {
        portTextField.clear();
        portTextField.sendKeys(port);
    }

    /**
     * Set the Password text field.
     *
     * @param password String that's the password text.
     */
    public void setPasswordTextField(final String password) {
        passwordTextField.clear();
        passwordTextField.sendKeys(password);
    }

    /**
     * Set the User text field.
     *
     * @param user String that's the user text.
     */
    public void setUserField(final String user) {
        userTextField.clear();
        userTextField.sendKeys(user);
    }

    /**
     * Set the Data base text field.
     *
     * @param dataBase String that's the Data base text.
     */
    public void setDataBaseTextField(final String dataBase) {
        dataBaseTextField.clear();
        dataBaseTextField.sendKeys(dataBase);
    }

    /**
     * This method set the steps for services.
     *
     * @param serviceMap Map whit parameters about the steps.
     * @return Map whit the steps to create a service.
     */
    public Map<ServiceFieldStep, Steps> getServiceFieldStepsMap(final Map<ServiceFieldStep, String> serviceMap) {
        Map<ServiceFieldStep, Steps> strategyMap = new HashMap<>();
        strategyMap.put(ServiceFieldStep.SERVICENAME,
                () -> selectServiceDropdown(serviceMap.get(ServiceFieldStep.SERVICENAME)));
        strategyMap.put(ServiceFieldStep.TOKEN,
                () -> setTokenTextField(serviceMap.get(ServiceFieldStep.TOKEN)));
        strategyMap.put(ServiceFieldStep.DESCRIPTION,
                () -> setDescriptionTextField(serviceMap.get(ServiceFieldStep.DESCRIPTION)));
        strategyMap.put(ServiceFieldStep.SERVERADDRESS,
                () -> setServerAddressTextField(serviceMap.get(ServiceFieldStep.SERVERADDRESS)));
        strategyMap.put(ServiceFieldStep.USERNAME,
                () -> setUserNameTextField(serviceMap.get(ServiceFieldStep.USERNAME)));
        strategyMap.put(ServiceFieldStep.USERPASSWORD,
                () -> setUserPasswordTextFieldTextField(serviceMap.get(ServiceFieldStep.USERPASSWORD)));
        strategyMap.put(ServiceFieldStep.APIBASEURL,
                () -> setApiBaseUrlTextField(serviceMap.get(ServiceFieldStep.APIBASEURL)));
        strategyMap.put(ServiceFieldStep.HOST,
                () -> setHostTextField(serviceMap.get(ServiceFieldStep.HOST)));
        strategyMap.put(ServiceFieldStep.PORT,
                () -> setPortTextField(serviceMap.get(ServiceFieldStep.PORT)));
        strategyMap.put(ServiceFieldStep.PASSWORD,
                () -> setPasswordTextField(serviceMap.get(ServiceFieldStep.PASSWORD)));
        strategyMap.put(ServiceFieldStep.USER,
                () -> setUserField(serviceMap.get(ServiceFieldStep.USER)));
        strategyMap.put(ServiceFieldStep.DATABASE,
                () -> setDataBaseTextField(serviceMap.get(ServiceFieldStep.DATABASE)));
        return strategyMap;
    }

    /**
     * Match the required project whit the respective button of configuration.
     *
     * @param projectType Kind of project.
     * @param projectName Project name.
     */
    public void clickOnConfigureProject(final String projectType, final String projectName) {
        List<WebElement> servicesList = columnServices.findElements(By.className("column"));

        for (WebElement x : servicesList) {
            if (x.findElement(By.cssSelector("div.sub.header.truncated.text")).getText().equals(projectType)
                    && x.findElement(By.cssSelector("h4.ui.header  > [class=\"truncated text\"]"))
                    .getText().equals(projectName)) {
                x.findElement(By.cssSelector("i.setting.link.icon")).click();
            }
        }
    }
}
