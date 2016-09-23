Feature: Test for login in Mach2 project

  Scenario: Login to Mach2
    When I send my login data
    Then The favorites page is displayed
    And I logout of the page
