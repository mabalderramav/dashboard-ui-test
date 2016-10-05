Feature: Project widget

  Background: login
    Given I send a POST request to /projects
      | name                              | AT01 project-01 |
      | iteration_length                  | 1               |
      | week_start_day                    | Monday          |
      | point_scale                       | 0,1,2,3         |
      | start_date                        | 2016-08-29      |
      | number_of_done_iterations_to_show | 12              |
      | initial_velocity                  | 10              |
    And I expect the status code 200
    And Synchronize Mach2 with Pivotal Tracker and project AT01-PivotalTracker

  @deleteAllProjects  @addPivotalTrackerService
  Scenario: Verify that the info in the Name field on a INFO in M2 is the same as on PT
    When I add a info widget in the board and I select the Project option
    Then Verify that all project information is the same that the project on Pivotal Tracker

  @deleteAllProjects
  Scenario: Verify that the all project into INFO widget is displayed in Mach2
    When I add a info widget in the board and I select the Project option
    And I add all columns
    Then Verify that all project information is the same that the project on Pivotal Tracker