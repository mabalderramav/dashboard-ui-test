package org.fundacionjala.dashboard.ui.pages.content.widget;

/**
 * Interface Manage Project type Widget page.
 *
 * @param <T> Generic data that manage a list of map or a map.
 */
public interface TypeWidget<T> {

    /**
     * Method to get the type for projects.
     *
     * @return a Map with the information of the features.project type.
     */
    T getDataFromWidget();
}
