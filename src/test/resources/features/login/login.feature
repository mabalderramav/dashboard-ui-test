Feature: Login

  Scenario: Login to Mach2
    When I perform a login to Mach2
    Then I will have a session started

    Scenario: User already logged
      When I had a session already started
      Then I expect not to log again