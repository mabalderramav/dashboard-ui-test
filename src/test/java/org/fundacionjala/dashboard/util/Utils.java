package org.fundacionjala.dashboard.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.fundacionjala.dashboard.cucumber.stepdefinition.ui.AssertTable;
import org.fundacionjala.dashboard.utils.DataTimeManager;

import static org.fundacionjala.dashboard.cucumber.stepdefinition.ui.project.ProjectParameters.CURRENT_ITERATION;
import static org.fundacionjala.dashboard.cucumber.stepdefinition.ui.project.ProjectParameters.CURRENT_VELOCITY;
import static org.fundacionjala.dashboard.cucumber.stepdefinition.ui.project.ProjectParameters.INITIAL_VELOCITY;
import static org.fundacionjala.dashboard.cucumber.stepdefinition.ui.project.ProjectParameters.ITERATION_LENGTH;
import static org.fundacionjala.dashboard.cucumber.stepdefinition.ui.project.ProjectParameters.NAME;
import static org.fundacionjala.dashboard.cucumber.stepdefinition.ui.project.ProjectParameters.POINT_SCALE;
import static org.fundacionjala.dashboard.cucumber.stepdefinition.ui.project.ProjectParameters.PROJECT_STARTED_AT;
import static org.fundacionjala.dashboard.cucumber.stepdefinition.ui.project.ProjectParameters.WEEK_START_DAY;
import static org.fundacionjala.dashboard.cucumber.stepdefinition.ui.story.StoryParameters.OWNERS;
import static org.fundacionjala.dashboard.cucumber.stepdefinition.ui.story.StoryParameters.POINTS;
import static org.fundacionjala.dashboard.cucumber.stepdefinition.ui.story.StoryParameters.STATE;
import static org.fundacionjala.dashboard.cucumber.stepdefinition.ui.story.StoryParameters.TYPE;

/**
 * Class to help with operations.
 */
public final class Utils {
    /**
     * Private Constructor.
     */
    private Utils() {
    }

    /**
     * Method to find an element into and List of Map.
     *
     * @param value   the searched value.
     * @param rowList the List where the the Value is searched.
     * @return a Map if the value is found.
     */
    public static Map<String, String> findElementInArray(final String value, final List<Map<String, String>> rowList) {
        return rowList.stream()
                .filter(e -> e.containsValue(value))
                .findFirst()
                .get();
    }

    /**
     * Method to find an element into and List of Response.
     *
     * @param value        the searched value.
     * @param responseList the List where the the Value is searched.
     * @return a JsonPath if the value is found.
     */
    public static JsonPath findElementJson(final String value, final List<Response> responseList) {
        return responseList.stream()
                .filter(e -> e.jsonPath().get("name").equals(value))
                .findFirst()
                .get()
                .jsonPath();
    }

    /**
     * Method to map the strategy fo make the assertions.
     *
     * @param jsonPath the response values
     * @return the Map with the information to be validated.
     */
    public static Map<String, AssertTable> mapStrategyWidgetAssert(final JsonPath jsonPath) {
        Map<String, AssertTable> strategyMap = new HashMap<>();

        strategyMap.put(NAME.toString(), () -> jsonPath.get("name"));
        strategyMap.put(CURRENT_ITERATION.toString(), () -> jsonPath.get("current_iteration_number").toString());
        strategyMap.put(WEEK_START_DAY.toString(), () -> jsonPath.get("week_start_day"));
        strategyMap.put(CURRENT_VELOCITY.toString(), () -> jsonPath.get("initial_velocity").toString());
        strategyMap.put(ITERATION_LENGTH.toString(), () -> jsonPath.get("iteration_length").toString());
        strategyMap.put(POINT_SCALE.toString(), () -> jsonPath.get("point_scale"));
        strategyMap.put(INITIAL_VELOCITY.toString(), () -> jsonPath.get("initial_velocity").toString());
        strategyMap.put(PROJECT_STARTED_AT.toString(),
                () -> DataTimeManager.parserDataTimeToFirstFormat(jsonPath.get("start_date").toString()));

        strategyMap.put(STATE.toString(), () -> jsonPath.get("current_state").toString());
        strategyMap.put(POINTS.toString(), () -> jsonPath.get("estimate").toString());
        strategyMap.put(TYPE.toString(), () -> jsonPath.get("story_type").toString());
        strategyMap.put(OWNERS.toString(), () -> " ");

        return strategyMap;
    }

    /**
     * Method to filter the response List by kind parameter.
     *
     * @param responseList The list used to filter.
     * @param kind         parameter to filter.
     * @return the list filtered.
     */
    public static List<Response> filterResponseByKind(final List<Response> responseList, final String kind) {
        return responseList.stream().filter(
                response -> response.jsonPath().get("kind").equals(kind)
        ).collect(Collectors.toList());
    }
}
