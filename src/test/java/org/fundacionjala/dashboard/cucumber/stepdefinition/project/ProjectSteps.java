package org.fundacionjala.dashboard.cucumber.stepdefinition.project;

import cucumber.api.java.en.When;
import org.fundacionjala.dashboard.cucumber.stepdefinition.dashboard.WidgetSteps;
import org.fundacionjala.dashboard.ui.pages.content.ConfigTableProject;
import org.fundacionjala.dashboard.ui.pages.content.ProjectTableWidget;
import org.fundacionjala.dashboard.ui.pages.content.Widget;
import org.fundacionjala.dashboard.ui.pages.content.WidgetPage;
import org.fundacionjala.dashboard.ui.pages.menu.StoryServiceForm;

import java.util.Map;

/**
 * Class to manage Step definition  for table widget of features.project.
 */
public class ProjectSteps {
    private WidgetSteps widgetSteps;

    /**
     * Constructor method that initializes the widget steps.
     *
     * @param newWidgetSteps The steps of the widget.
     */
    public ProjectSteps(final WidgetSteps newWidgetSteps) {
        this.widgetSteps = newWidgetSteps;
    }

    /**
     * Method to Select the features.project option form the UI.
     */
    @When("^I select the Project option$")
    public void iSelectTheProjectOption() {
        final Widget type = widgetSteps.getType();
        WidgetPage widgetPage = new WidgetPage();
        StoryServiceForm storyServiceForm = widgetPage.clickWidgetType(type);
        ConfigTableProject configTableForm = storyServiceForm.clickOpenProject();
        ProjectTableWidget projectTableWidget = configTableForm.clickSaveConfigurationProject();
        Map<String, String> tableProjectValues = projectTableWidget.getProjectTable();
    }

}
