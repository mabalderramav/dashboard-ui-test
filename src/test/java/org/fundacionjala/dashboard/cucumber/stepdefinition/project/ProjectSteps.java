package org.fundacionjala.dashboard.cucumber.stepdefinition.project;

import cucumber.api.java.en.When;
import org.fundacionjala.dashboard.cucumber.stepdefinition.dashboard.WidgetSteps;
import org.fundacionjala.dashboard.ui.pages.content.widget.ConfigTableProject;
import org.fundacionjala.dashboard.ui.pages.content.widget.ExceptionWidget;
import org.fundacionjala.dashboard.ui.pages.content.widget.ProjectTypeWidget;
import org.fundacionjala.dashboard.ui.pages.content.widget.Widget;
import org.fundacionjala.dashboard.ui.pages.content.widget.WidgetPage;
import org.fundacionjala.dashboard.ui.pages.menu.StoryServiceForm;

import java.util.Map;

/**
 * Class to manage Step definition  for table widget of features.project.
 */
public class ProjectSteps {
    private WidgetSteps widgetSteps;

    public ProjectSteps(WidgetSteps widgetSteps) {
        this.widgetSteps = widgetSteps;
    }

    /**
     * Method to Select the features.project option form the UI.
     */
    @When("^I select the Project option$")
    public void iSelectTheProjectOption() throws ExceptionWidget {
        final Widget type = widgetSteps.getType();
        WidgetPage widgetPage = new WidgetPage();
        StoryServiceForm storyServiceForm = widgetPage.clickWidgetType(type);
        ConfigTableProject configTableForm = storyServiceForm.clickOpenProject();//StoryServiceForm - Why this name?
        ProjectTypeWidget projectTypeWidget = configTableForm.clickSaveConfigurationProject(type);
        Map<String, String> tableProjectValues = projectTypeWidget.getProjectType();
    }

}
