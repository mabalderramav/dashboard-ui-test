package org.fundacionjala.dashboard.cucumber.stepdefinition.ui;

/**
 * Enum to define the values to be assert.
 */
public enum AssertParameters {
    NAME,
    CURRENT_ITERATION,
    WEEK_START_DAY,
    CURRENT_VELOCITY,
    ITERATION_LENGTH,
    POINT_SCALE,
    PROJECT_STARTED_AT,
    INITIAL_VELOCITY;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
