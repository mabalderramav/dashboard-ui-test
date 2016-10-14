package org.fundacionjala.dashboard.cucumber.stepdefinition.api;


import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import io.restassured.response.Response;

import org.apache.commons.lang3.StringUtils;
import org.fundacionjala.dashboard.api.Mapper;
import org.fundacionjala.dashboard.api.RequestManager;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * This class is in charge to manage the steps definitions.
 */
public class ResourcesSteps {

    public static final int STATUS_200 = 200;
    private static final int STATUS_204 = 204;
    private List<Response> responseList;

    /**
     * Constructor.
     */
    public ResourcesSteps() {
        responseList = new ArrayList<>();
    }

    /**
     * Method to store the response.
     *
     * @param key that identify the response.
     */
    @And("^I store as (.*)")
    public void storedAs(final String key) {
        for (Response resp : responseList) {
            Mapper.addResponse(key, resp);
        }
    }

    /**
     * Method to validate the Get request.
     *
     * @param endPoint end point of the get request.
     */
    @When("^I send a GET request to (.*)$")
    public void iSendAGetRequestTo(final String endPoint) {
        Response get = RequestManager.get(Mapper.mapEndpoint(endPoint));
        assertEquals(STATUS_200, get.getStatusCode());
        responseList.add(get);
    }

    /**
     * Method to validate the post request.
     *
     * @param endPoint end point of the post request.
     * @param jsonData data in map format.
     */
    @When("^I send a POST request to (.*)")
    public void iSendAPostRequestTo(final String endPoint, final Map<String, Object> jsonData) {
        Response post = RequestManager.post(Mapper.mapEndpoint(endPoint), jsonData);
        assertEquals(STATUS_200, post.getStatusCode());
        responseList.add(post);
    }

    /**
     * Method to validate the post request for a given list of map.
     *
     * @param endPoint     end point of the post request.
     * @param jsonDataList List of data in map format.
     */
    @When("^I send a POST request with list to (.*)")
    public void iSendAPostRequestWithListTo(final String endPoint,
                                            final List<Map<String, Object>> jsonDataList) {

        jsonDataList.forEach(jsonData -> {
            Map<String, Object> newJsonData = new LinkedHashMap<>(jsonData);

            jsonData.forEach((key, value) -> {
                if (StringUtils.isEmpty(String.valueOf(value))) {
                    newJsonData.remove(key, value);
                }
            });
            Response post = RequestManager.post(Mapper.mapEndpoint(endPoint), newJsonData);
            assertEquals(STATUS_200, post.getStatusCode());
            responseList.add(post);
        });
    }

    /**
     * Method to validate the put request.
     *
     * @param endPoint end point of the put request.
     * @param jsonData data in Map format.
     */
    @When("^I send a PUT request to (.*)$")
    public void iSendAPutRequestTo(final String endPoint, final Map<String, Object> jsonData) {
        Response put = RequestManager.put(Mapper.mapEndpoint(endPoint), jsonData);
        assertEquals(STATUS_200, put.getStatusCode());
        responseList.add(put);
    }

    /**
     * Method to validate delete request.
     *
     * @param endPoint end point of the delete request.
     */
    @When("^I send a DELETE request to (.*)$")
    public void iSendADeleteRequestTo(final String endPoint) {
        Response delete = RequestManager.delete(Mapper.mapEndpoint(endPoint));
        assertEquals(STATUS_204, delete.getStatusCode());
        responseList.add(delete);
    }

    /**
     * Get the Response List.
     *
     * @return the responseList.
     */
    public List<Response> getResponseList() {
        return responseList;
    }
}
