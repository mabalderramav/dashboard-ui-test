Feature: Login

  Scenario: Login to Mach23
    When I perform a login as
      | userName | Alvaro.Daza@fundacion-jala.org |
      | password | P@ssw0rd                       |
    Then I will have a user logged
