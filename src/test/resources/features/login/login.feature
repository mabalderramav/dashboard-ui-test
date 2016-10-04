Feature: Login

  Scenario: Login to Mach23
    When I perform a login as
      | userName | Aldo.Balderrama@fundacion-jala.org |
      | password | 04Noviembre                        |
    Then I will have a user logged

