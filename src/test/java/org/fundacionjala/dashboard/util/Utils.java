package org.fundacionjala.dashboard.util;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.fundacionjala.dashboard.utils.DataTimeManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.fundacionjala.dashboard.cucumber.stepdefinition.ui.project.AssertTable.CURRENT_ITERATION;
import static org.fundacionjala.dashboard.cucumber.stepdefinition.ui.project.AssertTable.CURRENT_VELOCITY;
import static org.fundacionjala.dashboard.cucumber.stepdefinition.ui.project.AssertTable.INITIAL_VELOCITY;
import static org.fundacionjala.dashboard.cucumber.stepdefinition.ui.project.AssertTable.ITERATION_LENGTH;
import static org.fundacionjala.dashboard.cucumber.stepdefinition.ui.project.AssertTable.NAME;
import static org.fundacionjala.dashboard.cucumber.stepdefinition.ui.project.AssertTable.POINT_SCALE;
import static org.fundacionjala.dashboard.cucumber.stepdefinition.ui.project.AssertTable.PROJECT_STARTED_AT;
import static org.fundacionjala.dashboard.cucumber.stepdefinition.ui.project.AssertTable.WEEK_START_DAY;


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
     * @param value the searched value.
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
    public static Map<String, String> mapStrategyWidget(final JsonPath jsonPath) {
        Map<String, String> strategyMap = new HashMap<>();

        strategyMap.put(NAME.toString(), jsonPath.get("name"));
        strategyMap.put(CURRENT_ITERATION.toString(), jsonPath.get("current_iteration_number").toString());
        strategyMap.put(WEEK_START_DAY.toString(), jsonPath.get("week_start_day"));
        strategyMap.put(CURRENT_VELOCITY.toString(), jsonPath.get("initial_velocity").toString());
        strategyMap.put(ITERATION_LENGTH.toString(), jsonPath.get("iteration_length").toString());
        strategyMap.put(POINT_SCALE.toString(), jsonPath.get("point_scale"));
        strategyMap.put(INITIAL_VELOCITY.toString(), jsonPath.get("initial_velocity").toString());
        strategyMap.put(PROJECT_STARTED_AT.toString(),
                DataTimeManager.parserDataTimeToFirstFormat(jsonPath.get("start_date").toString()));

        return strategyMap;
    }

    /**
     * Method to map the strategy fo make the assertions for story.
     *
     * @param jsonPath the response values
     * @return the Map with the information to be validated.
     */
    public static Map<String, String> mapStrategyWidgetStory(final JsonPath jsonPath) {
        Map<String, String> strategyMap = new HashMap<>();

        strategyMap.put(NAME.toString(), jsonPath.get("name"));

        strategyMap.put(STATE.toString(), jsonPath.get("current_state").toString());
        strategyMap.put(POINTS.toString(), jsonPath.get("estimate").toString());
        strategyMap.put(TYPE.toString(), jsonPath.get("story_type").toString());
        strategyMap.put(OWNERS.toString(), " ");

        return strategyMap;
    }
}
