
package org.fundacionjala.dashboard.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * Created by ErickaViraca on 9/22/2016.
 */
public final class DataTimeManager {
    private static final Logger LOGGER = LogManager.getLogger(DataTimeManager.class);
    private static SimpleDateFormat machFormat = new SimpleDateFormat("MMM d" + ", " + "yyyy");
    private static SimpleDateFormat firstPivotalParser = new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat secondPivotalParser = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX");
    private static int quantitySubtractionMonths = 1;
    private static Date date = null;

    /**
     * DataTimerManager constructor method.
     */
    private DataTimeManager() {
    }

    /**
     * method to return a valid data time to create a project.
     *
     * @return a valid date value, to create a project.
     */
    public static String getDataTimeForCreateAProject() {
        Calendar x = Calendar.getInstance();
        x.add(Calendar.MONTH, -quantitySubtractionMonths);
        return firstPivotalParser.format(x.getTime());
    }

    /**
     * Method to parser the data time of Pivotal Tracker form the first format "2016-09-13".
     *
     * @param dataTimeFirstFormat first date time kind to parse.
     * @return formatted date on a string.
     */
    public static String parserDataTimeToFirstFormat(final String dataTimeFirstFormat) {
        try {
            date = firstPivotalParser.parse(dataTimeFirstFormat);
        } catch (ParseException e) {
            e.printStackTrace();
            LOGGER.error("Error parsing the date converting the format");
        }
        return machFormat.format(date);
    }

    /**
     * Method to parser the data time of Pivotal Tracker form the first format "2016-09-13T12:00:10Z".
     *
     * @param dataTimeFirstFormat second date time kind to parse.
     * @return formatted date on a string.
     */
    public static String parserDataTimeToSecondFormat(final String dataTimeFirstFormat) {
        try {
            date = secondPivotalParser.parse(dataTimeFirstFormat);
        } catch (ParseException e) {
            e.printStackTrace();
            LOGGER.error("Error parsing the date converting the format");
        }
        return machFormat.format(date);
    }
}
