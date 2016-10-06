Feature: Login

  Scenario: Login to Mach23455
    When I perform a login as
      | userName | bruno.vasquez@fundacion-jala.org |
      | password | br2bruno                         |
    And I add a service
      | SERVICENAME | Pivotal Tracker                  |
      | TOKEN       | 6d7559555b6bded8c69c35db1746cabe |
      | DESCRIPTION | Juanilla                         |
    And Synchronize Mach2 with Pivotal Tracker and project Juanilla
    And I add a table widget in the board and I select the TASK_BURN option
      | PROJECTS     | AT - 01 project02 |
      | ITERATION    | IT 2              |
      | ADVANCES     |                   |
      | TO_ITERATION | IT 4              |
      | OWNER        | bruno             |
      | STORY_TYPE   | Bugs              |

