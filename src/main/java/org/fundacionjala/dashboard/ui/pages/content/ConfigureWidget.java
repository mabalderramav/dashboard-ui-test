package org.fundacionjala.dashboard.ui.pages.content;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.fundacionjala.dashboard.ui.pages.AbstractBasePage;
import org.fundacionjala.dashboard.ui.pages.Steps;
import org.fundacionjala.dashboard.ui.pages.content.widget.EnumConfigure;

/**
 * Class widget configurations.
 */
public class ConfigureWidget extends AbstractBasePage {

    public static final int WAIT_TIME = 2000;
    @FindBy(css = "div[data-key='Project'] div.ui.dropdown input.search")
    private WebElement autoCompleteProject;

    @FindBy(css = "div[data-key='Iteration'] div.ui.dropdown input.search")
    private WebElement autoCompleteIteration;

    @FindBy(css = "div[data-key='ToIteration'] div.ui input.search")
    private WebElement autoCompleteToIteration;

    @FindBy(css = "div[data-key='Labels'] div.ui div.ui input")
    private WebElement autoCompleteLabel;

    @FindBy(css = "div[data-key='Owner'] div.ui input.search")
    private WebElement autoCompleteOwner;

    @FindBy(css = "button[data-action='save-wizard-config']")
    private WebElement saveButton;

    @FindBy(css = "a.link[data-id='advanced-config'] > b")
    private WebElement advancesDroopDown;

    @FindBy(css = "div.column div.ui.toggle.checkbox")
    private WebElement includeIterationButton;

    @FindBy(css = "div[data-key='NumberOfLastIterations'] input")
    private WebElement numberLastIterationTextField;

    @FindBy(css = "div[data-key='VelocityStrategy'] input.search")
    private WebElement velocityIterations;

    @FindBy(css = "div[data-key='AverageCalculationMethod'] input.search")
    private WebElement averageMethodCalculation;

    @FindBy(css = "div[data-key='StoryType'] input.search")
    private WebElement storyTypeSelector;

    @FindBy(css = "div.wizard-modal.ui.top.attached.modal.tiny.transition.visible.active > "
            + "div.ui.clearing.secondary.basic.segment.wizard-modal-content")
    private WebElement popupWizard;

    @FindBy(css = "div.menu.transition.visible  div.item")
    private WebElement itemsDropDownList;

    private By element = By.cssSelector("div.menu.transition.visible  div.item");

    /**
     * Sends a name project to a dropdown selector.
     *
     * @param project is a string project name to select.
     */
    public void autoCompleteProject(final String project) {
        autoCompleteProject.sendKeys(project);
        autoCompleteProject.sendKeys(Keys.ENTER);
    }

    /**
     * Sends a iteration number to a dropdown selector.
     *
     * @param iteration is a string iteration number to select.
     */
    public void autoCompleteIteration(final String iteration) {
        clickIteration();
        try {
            Thread.sleep(WAIT_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(element));
        driver.findElements(element)
                .stream()
                .filter(webElement -> webElement.getText().equals(iteration))
                .findFirst().get().click();
    }

    /**
     * Makes click on save button.
     *
     * @return the result of the configurations.
     */
    public StoryItemTable clickSaveConfigurationStoryItem() {
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("div[data-key='Iteration'] div.ui div.text")));
        wait.until(ExpectedConditions.attributeToBeNotEmpty(
                driver.findElement(By.cssSelector("div[data-key='Iteration'] div.ui input[type='hidden']")), "value"));
        wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        saveButton.click();
        return new StoryItemTable();
    }

    /**
     * Makes click to open the advanced configuration.
     */
    public void clickAdvancesDroopDown() {
        wait.until(ExpectedConditions.elementToBeClickable(advancesDroopDown));
        advancesDroopDown.click();
    }

    /**
     * Changes the state to include and Iteration to doesn't include.
     */
    public void clickIncludeIterationButton() {
        wait.until(ExpectedConditions.elementToBeClickable(includeIterationButton));
        includeIterationButton.click();
    }

    /**
     * Sends a to iteration number to a dropdown selector.
     *
     * @param toIteration is a string to iteration number to select.
     */
    public void selectToIteration(final String toIteration) {
        wait.until(ExpectedConditions.elementToBeClickable(autoCompleteToIteration));
        autoCompleteToIteration.sendKeys(toIteration);
    }

    /**
     * Sends the number of the last iteration to a test field.
     *
     * @param numberLastIteration is a string to iteration number to select.
     */
    public void fillNumberLastIterationTextField(final String numberLastIteration) {
        wait.until(ExpectedConditions.elementToBeClickable(numberLastIterationTextField));
        numberLastIterationTextField.clear();
        numberLastIterationTextField.sendKeys(numberLastIteration);
    }

    /**
     * Sends the label to field.
     *
     * @param labels is a string to use for filter.
     */
    public void writeALabel(final String labels) {
        wait.until(ExpectedConditions.elementToBeClickable(autoCompleteLabel));
        autoCompleteLabel.sendKeys(labels);
    }

    /**
     * Sends a owner name to a selector.
     *
     * @param owner is a string of the owner name.
     */
    public void selectOwner(final String owner) {
        wait.until(ExpectedConditions.elementToBeClickable(autoCompleteOwner));
        autoCompleteOwner.sendKeys(owner);

    }

    /**
     * Sends a iteration name to a selector.
     *
     * @param iteration is a string of the iteration name.
     */
    private void selectVelocityIterations(final String iteration) {
        wait.until(ExpectedConditions.elementToBeClickable(velocityIterations));
        velocityIterations.sendKeys(iteration);
    }

    /**
     * Sends an average to a selector.
     *
     * @param typeAverage is a string that represents the average quantity.
     */
    private void selectAverageMethodCalculation(final String typeAverage) {
        wait.until(ExpectedConditions.elementToBeClickable(averageMethodCalculation));
        averageMethodCalculation.sendKeys(typeAverage);
    }

    /**
     * Sends the story type to a selector.
     *
     * @param storyType Is a string that represents the story type.
     */
    private void selectStoryType(final String storyType) {
        wait.until(ExpectedConditions.elementToBeClickable(storyTypeSelector));
        storyTypeSelector.sendKeys(storyType);
    }

    /**
     * Executes the configurations sent.
     *
     * @param configureMap is a map that contains the configurations.
     */
    public void setConfiguration(final Map<EnumConfigure, String> configureMap) {
        Map<EnumConfigure, Steps> strategyOption = strategyConfigureOption(configureMap);

        Set<EnumConfigure> keys = configureMap.keySet();
        for (EnumConfigure key : keys) {
            strategyOption.get(key).executeStep();
        }
    }

    /**
     * Makes click on the form save button.
     */
    public void clickSave() {
        wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        saveButton.click();
    }

    /**
     * Click to iteration dropdown selector.
     */
    public void clickIteration() {
        wait.until(ExpectedConditions.elementToBeClickable(autoCompleteIteration));
        autoCompleteIteration.click();
    }

    /**
     * this method do a click on the drop down list.
     *
     * @return list.
     */
    public List<WebElement> clickProjectDropdownField() {
        wait.until(ExpectedConditions.elementToBeClickable(autoCompleteProject));
        autoCompleteProject.click();
        List<WebElement> allProjectElements = driver.findElements(By.cssSelector("div[data-key='Project'] "
                + "div.ui.dropdown div.menu div"));
        return allProjectElements;
    }

    /**
     * method get the size of the story iteration.
     *
     * @return integer whit the quantity.
     */
    public Integer getStoryIterationSize() {
        List<WebElement> storyIterationSize = driver.findElements(By.cssSelector(
                "div.menu.transition.visible  div.item"))
                .stream()
                .filter(webElement -> webElement.getText().contains("IT"))
                .collect(Collectors.toList());
        return storyIterationSize.size();
    }

    /**
     * method makes a click out of the wizard widget.
     */
    public void clickOut() {
        final int positionX = -100;
        final int positionY = 100;
        wait.until(ExpectedConditions.elementToBeClickable(popupWizard));
        Actions action = new Actions(driver);
        action.moveToElement(popupWizard, positionX, positionY).click().build().perform();
    }

    /**
     * Create an strategy steps configuration options filling a map with
     * all the existing configurations.
     *
     * @param configureMap is a map that contains all the configurations.
     * @return the configure map with strategies.
     */
    private Map<EnumConfigure, Steps> strategyConfigureOption(final Map<EnumConfigure, String> configureMap) {

        Map<EnumConfigure, Steps> strategyMap = new HashMap<>();
        strategyMap.put(EnumConfigure.PROJECTS,
                () -> autoCompleteProject(configureMap.get(EnumConfigure.PROJECTS)));
        strategyMap.put(EnumConfigure.ITERATION,
                () -> autoCompleteIteration(configureMap.get(EnumConfigure.ITERATION)));
        strategyMap.put(EnumConfigure.ADVANCES,
                this::clickAdvancesDroopDown);
        strategyMap.put(EnumConfigure.TO_ITERATION,
                () -> selectToIteration(configureMap.get(EnumConfigure.TO_ITERATION)));
        strategyMap.put(EnumConfigure.LABEL,
                () -> writeALabel(configureMap.get(EnumConfigure.LABEL)));
        strategyMap.put(EnumConfigure.OWNER,
                () -> selectOwner(configureMap.get(EnumConfigure.OWNER)));
        strategyMap.put(EnumConfigure.INCLUDE_CURRENT_ITERATION,
                this::clickIncludeIterationButton);
        strategyMap.put(EnumConfigure.SHOW_WEEKENDS,
                this::clickIncludeIterationButton);
        strategyMap.put(EnumConfigure.NUMBER_LAST_ITERATION,
                () -> fillNumberLastIterationTextField(configureMap.get(EnumConfigure.NUMBER_LAST_ITERATION)));
        strategyMap.put(EnumConfigure.VELOCITY_ITERATIONS,
                () -> selectVelocityIterations(configureMap.get(EnumConfigure.VELOCITY_ITERATIONS)));
        strategyMap.put(EnumConfigure.AVERAGE_CALCULATION_METHOD,
                () -> selectAverageMethodCalculation(configureMap.get(EnumConfigure.AVERAGE_CALCULATION_METHOD)));
        strategyMap.put(EnumConfigure.STORY_TYPE,
                () -> selectStoryType(configureMap.get(EnumConfigure.STORY_TYPE)));
        return strategyMap;
    }
}
