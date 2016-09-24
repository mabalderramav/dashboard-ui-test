package org.fundacionjala.dashboard.ui.page;

import org.fundacionjala.dashboard.ui.page.projectwidget.ConfigTableProject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by brunovasquez on 9/22/2016.
 */
public class ServiceForm extends AbstractBasePage {

    @FindBy(xpath = "//div[@id='mach-wizard']/div/div[3]/div/div/div[2]/div[1]/div[2]/div")
    private WebElement projectButton;
        public final ConfigTableProject clickOpenProject() {
        projectButton.click();
        return new ConfigTableProject();
    }
}
