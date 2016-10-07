package org.fundacionjala.dashboard.cucumber.hooks;

import cucumber.api.java.Before;
import org.fundacionjala.dashboard.api.RequestManager;

import java.util.List;
import java.util.Map;

import static org.fundacionjala.dashboard.api.RequestManager.delete;

/**
 * Hook to delete all projects that is created with the feature.
 */
public class ProjectHooks {

    private static final String PROJECTS_ENDPOINT = "/projects/";

    private static final String ID_KEY = "id";

    /**
     * Method to delete all projects that meets with the condition.
     */
    @Before("@deleteAllProjects")
    public final void deleteAllProject() {
        List<Map<String, ?>> projects = RequestManager.get(PROJECTS_ENDPOINT).jsonPath().get();
        for (Map<String, ?> object : projects) {
            delete(PROJECTS_ENDPOINT + object.get(ID_KEY).toString());
        }
    }
}
