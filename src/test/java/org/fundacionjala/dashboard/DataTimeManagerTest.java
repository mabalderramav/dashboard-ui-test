package org.fundacionjala.dashboard;

import org.fundacionjala.dashboard.utility.DataTimeManager;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ErickaViraca on 9/22/2016.
 */
public class DataTimeManagerTest {

    private final String dataTimeFirstFormat = "2016-05-30";
    private final String dataTimeSecondFormat = "2016-09-13T12:00:05Z";
    private String expectedValue = "";

    /**
     * test for the getDataTimeForCreateAProject method.
     */
    @Test
    public final void testDataTime() {
        expectedValue = "2016-08-23";
        assertEquals(expectedValue, DataTimeManager.getDataTimeForCreateAProject());
    }

    /**
     * test for the parserDataTimeToFirstFormat method.
     */
    @Test
    public final void testParserDataTimeToFirstFormat() {
        expectedValue = "May 30, 2016";
        assertEquals(expectedValue, DataTimeManager.parserDataTimeToFirstFormat(dataTimeFirstFormat));
    }

    /**
     * test for the parserDataTimeToSecondFormat method.
     */
    @Test
    public final void testParserDataTimeToSecondFormat() {
        expectedValue = "Sep 13, 2016";
        assertEquals(expectedValue, DataTimeManager.parserDataTimeToSecondFormat(dataTimeSecondFormat));
    }

}
