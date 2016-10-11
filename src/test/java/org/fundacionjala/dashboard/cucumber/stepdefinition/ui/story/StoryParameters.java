package org.fundacionjala.dashboard.cucumber.stepdefinition.ui.story;

/**
 * Enum to define the values to be assert.
 */
public enum StoryParameters {

    NAME,
    STATE,
    POINTS,
    TYPE,
    OWNERS;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
