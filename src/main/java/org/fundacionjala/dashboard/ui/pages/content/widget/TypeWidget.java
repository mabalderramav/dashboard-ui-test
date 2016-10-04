package org.fundacionjala.dashboard.ui.pages.content.widget;

import java.util.List;
import java.util.Map;

/**
 * Interface Manage Project type Widget page.
 */
public interface TypeWidget {

    /**
     * Method to get the type for projects.
     *
     * @return a Map with the information of the features.project type.
     */
    List<Map<String, String>> getDataFromWidget();
}
