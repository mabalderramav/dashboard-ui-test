Feature: We need to add a service

  Background: Login to Mach2
    When I send my login data
    And The favorites page is displayed

  Scenario: Add a service
#    Given I want to add a service
    When I click  on the user dropdown list
    And Select the profile option
    And Click add service button
    And Click On dropdown List of services
    And Select the pivotal tracker option
    And Insert the information required
    And Click on save Services
    Then the profile page is displayed

