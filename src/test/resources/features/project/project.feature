Feature: Project widget

  Background: login

    Given I login with valid credentials to Mach2

    Given I send a POST request to /projects
      | name                              | AT01 project-01 |
      | iteration_length                  | 1               |
      | week_start_day                    | Monday          |
      | point_scale                       | 0,1,2,3         |
      | start_date                        | 2016-08-29      |
      | number_of_done_iterations_to_show | 12              |
      | initial_velocity                  | 10              |

    And I store as Project1
    Then I expect the status code 200
    #Given I have a configured service

    @deleteAllProjects
  Scenario: Validate All information of the projects from pivotal are displayed in Mach2 table widget
    Given I add a table widget in the board
    When I select the Project option
    Then All information of Pivotal Tracker projects should be displayed in project table widget of Mach2

  Scenario: Verify all Projects  from pivotal tracker are displayed when we add a List widget for Projects
    Given I add a List widget in the board
    When I select the Project option
    Then All Pivotal Tracker projects name should be displayed in project List widget of Mach2
