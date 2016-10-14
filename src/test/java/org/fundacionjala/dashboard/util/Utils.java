package org.fundacionjala.dashboard.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

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
        Optional<Map<String, String>> element = rowList.stream()
                .filter(e -> e.containsValue(value))
                .findFirst();
        if (element.isPresent()) {
            return element.get();
        } else {
            return new HashMap<>();
        }
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
