package org.fundacionjala.dashboard.ui.pages.content.widget;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.dashboard.ui.pages.AbstractBasePage;

/**
 * Manage Project Info Widget page.
 */
public class InfoWidget extends AbstractBasePage implements TypeWidget {
    @FindBy(css = "div.info-fields > div.ui.two.column.centered.grid.aligned.basic.field.segment")
    private WebElement projectInfo;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, String>> getDataFromWidget() {

        return new ArrayList<>();
    }
}
