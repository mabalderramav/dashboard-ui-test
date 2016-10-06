package org.fundacionjala.dashboard.ui.pages.content;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.fundacionjala.dashboard.ui.pages.AbstractBasePage;
import org.fundacionjala.dashboard.ui.pages.content.widget.EnumConfigure;
import org.fundacionjala.dashboard.ui.pages.menu.Steps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class widget configurations.
 */
public class ConfigureWidget extends AbstractBasePage {

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

    @FindBy(xpath = "//button[@data-action='save-wizard-config']")
    private WebElement saveButton;

    @FindBy(css = "a.link[data-id='advanced-config'] > b")
    private WebElement advancesDroopDown;

    @FindBy(xpath = "//button[@data-action='save-wizard-config']")
    private WebElement save;

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

    /**
     * Sends a name project to a dropdown selector.
     *
     * @param project is a string project name to select.
     */
    public final void autoCompleteProject(final String project) {
        autoCompleteProject.sendKeys(project);
        driver.findElement(By.cssSelector("div[data-key='Project'] div i")).click();
        driver.findElement(By.cssSelector("div[data-key='Project'] div i")).click();
    }

    /**
     * Sends a iteration number to a dropdown selector.
     *
     * @param iteration is a string iteration number to select.
     */
    public final void autoCompleteIteration(final String iteration) {
        autoCompleteIteration.sendKeys(iteration);
        driver.findElement(By.cssSelector("div[data-key='Iteration'] div i")).click();
        driver.findElement(By.cssSelector("div[data-key='Iteration'] div i")).click();
    }

    /**
     * Makes click on save button.
     *
     * @return the result of the configurations.
     */
    public final StoryItemTable clickSaveConfigurationStoryItem() {
        save.click();
        return new StoryItemTable();
    }

    /**
     * Makes click to open the advanced configuration.
     */
    public final void clickAdvancesDroopDown() {
        advancesDroopDown.click();
    }

    /**
     * Changes the state to include and Iteration to doesn't include.
     */
    public final void clickIncludeIterationButton() {
        includeIterationButton.click();
    }

    /**
     * Sends a to iteration number to a dropdown selector.
     *
     * @param toIteration is a string to iteration number to select.
     */
    public void selectToIteration(final String toIteration) {
        autoCompleteToIteration.sendKeys(toIteration);
    }

    /**
     * Sends the number of the last iteration to a test field.
     *
     * @param numberLastIteration is a string to iteration number to select.
     */
    public void fillNumberLastIterationTextField(final String numberLastIteration) {
        numberLastIterationTextField.clear();
        numberLastIterationTextField.sendKeys(numberLastIteration);
    }

    /**
     * Sends the label to field.
     *
     * @param labels is a string to use for filter.
     */
    public void writeALabel(final String labels) {
        autoCompleteLabel.sendKeys(labels);
    }

    /**
     * Sends a owner name to a selector.
     *
     * @param owner is a string of the owner name.
     */
    public void selectOwner(final String owner) {
        autoCompleteOwner.sendKeys(owner);

    }

    /**
     * Sends a iteration name to a selector.
     *
     * @param iterations is a string of the iteration name.
     */
    private void selectVelocityIterations(final String iterations) {
        velocityIterations.sendKeys(iterations);
    }

    /**
     * Sends an average to a selector.
     *
     * @param typeAverage is a string that represents the average quantity.
     */
    private void selectAverageMethodCalculation(final String typeAverage) {
        averageMethodCalculation.sendKeys(typeAverage);
    }

    /**
     * Sends the story type to a selector.
     *
     * @param storyType Is a string that represents the story type.
     */
    private void selectStoryType(final String storyType) {
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
    public final void clickSave() {
        saveButton.click();
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
