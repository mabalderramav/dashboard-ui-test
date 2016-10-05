package org.fundacionjala.dashboard.cucumber.stepdefinition.ui.project;

import cucumber.api.java.en.When;
import org.fundacionjala.dashboard.ui.pages.content.widget.InfoWidget;

/**
 * This class manage the project steps.
 */
public class ProjectSteps {
    /**
     * this method adds all fields for a given widget.
     */
    @When("^I add all columns$")
    public void addAllColumns() {
        InfoWidget infoWidget = new InfoWidget();
        while (infoWidget.existAddButton()) {
            infoWidget.clickAddButton();
        }
    }
}
