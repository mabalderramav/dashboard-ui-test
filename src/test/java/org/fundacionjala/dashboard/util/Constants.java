package org.fundacionjala.dashboard.util;

import java.util.HashMap;
import java.util.Map;

/**
 * This Class manage all constants.
 */
public final class Constants {

    public static final Map<String, Integer> COLUMNS_BY_DEFAULT;

    public static final String COLUMNS_TABLE = "columnsTable";

    private static final int COUNT_COLUMN_TABLE = 8;

    static {
        COLUMNS_BY_DEFAULT = new HashMap<>();
        COLUMNS_BY_DEFAULT.put(COLUMNS_TABLE, COUNT_COLUMN_TABLE);
    }

    /**
     * Private constructor.
     */
    private Constants() {
    }
}
