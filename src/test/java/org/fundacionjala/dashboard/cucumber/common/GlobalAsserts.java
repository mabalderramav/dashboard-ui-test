package org.fundacionjala.dashboard.cucumber.common;

import java.util.List;
import java.util.Map;
import java.util.Set;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.fundacionjala.dashboard.cucumber.stepdefinition.ui.AssertTable;
import org.fundacionjala.dashboard.util.Utils;

import static org.junit.Assert.assertEquals;

/**
 * Class to manage the asserts for tables.
 */
public final class GlobalAsserts {

    private static final String NAME = "name";

    /**
     * Private constructor.
     */
    private GlobalAsserts() {

    }

    /**
     * Method that given a list of data execute the assertions for each values of the response.
     *
     * @param widgetValues List of Map with the information of the displayed data in UI.
     * @param responseList List with that contain the responses.
     */
    public static void executeListAssert(final List<Map<String, String>> widgetValues,
                                         final List<Response> responseList) {
        for (int i = 0; i < responseList.size(); i++) {
            JsonPath jsonPath = responseList.get(i).jsonPath();
            Map<String, String> row = Utils.findElementInArray(jsonPath.get(NAME), widgetValues);
            if (!row.isEmpty()) {
                executeAssert(row, jsonPath);
            }
        }
    }

    /**
     * Method to execute the asserts for each values of the response.
     *
     * @param map      Map with the information of the displayed data in UI.
     * @param jsonPath Json that contain the response.
     */
    public static void executeAssert(final Map<String, String> map, final JsonPath jsonPath) {
        Map<String, AssertTable> strategyMap = Utils.mapStrategyWidgetAssert(jsonPath);
        Set<String> keys = map.keySet();
        for (String key : keys) {
            String algo = strategyMap.get(key).executeAssert();
            assertEquals(map.get(key), algo);
        }
    }
}
