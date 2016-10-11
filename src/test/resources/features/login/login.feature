Feature: Login

  Scenario: Login to Mach23
    When I perform a login as
      | userName | testjala001@gmail.com |
      | password | .5930880Qa                       |
    Then I will have a user logged
