package org.fundacionjala.dashboard.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.restassured.path.json.JsonPath;

import org.fundacionjala.dashboard.utils.DataTimeManager;

import static org.fundacionjala.dashboard.cucumber.stepdefinition.ui.AssertParameters.CURRENT_ITERATION;
import static org.fundacionjala.dashboard.cucumber.stepdefinition.ui.AssertParameters.CURRENT_VELOCITY;
import static org.fundacionjala.dashboard.cucumber.stepdefinition.ui.AssertParameters.ITERATION_LENGTH;
import static org.fundacionjala.dashboard.cucumber.stepdefinition.ui.AssertParameters.NAME;
import static org.fundacionjala.dashboard.cucumber.stepdefinition.ui.AssertParameters.POINT_SCALE;
import static org.fundacionjala.dashboard.cucumber.stepdefinition.ui.AssertParameters.PROJECT_STARTED_AT;
import static org.fundacionjala.dashboard.cucumber.stepdefinition.ui.AssertParameters.WEEK_START_DAY;

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
        Map<String, String> result = rowList.stream().filter(e -> e.containsValue(value)).findFirst().get();
        return result;
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
        strategyMap.put(PROJECT_STARTED_AT.toString(),
                DataTimeManager.parserDataTimeToFirstFormat(jsonPath.get("start_date").toString()));

        return strategyMap;
    }
}
