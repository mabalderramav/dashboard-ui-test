package org.fundacionjala.dashboard.utility;

/**
 * Class to help with operations.
 */
public final class Utils {

    /**
     * Private constructor.
     */
    private Utils() {

    }

    /**
     * Method to build the name of key for a given a table header column name.
     *
     * @param key table column name.
     * @return the key built.
     */
    public static String replaceSpaceWithUnderscore(final String key) {
        return key.toLowerCase().replaceAll(" ", "_");
    }
}
