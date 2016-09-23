Feature: Test for login in Mach2 project

  Scenario: Login to Mach2
    When I send my password and username
    Then The favorites page is displayed

