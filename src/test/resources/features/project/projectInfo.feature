@deleteAllServices @addPivotalTrackerService
Feature: Project info widget

  Background: Create a Project in pivotal and synchronize with Mach2
     Given I send a POST request to /projects
      | name                              | AT01 project-01 |
      | iteration_length                  | 1               |
      | week_start_day                    | Monday          |
      | point_scale                       | 0,1,2,3         |
      | start_date                        | 2016-08-29      |
      | number_of_done_iterations_to_show | 12              |
      | initial_velocity                  | 10              |
    And Synchronize Mach2 with Pivotal Tracker description AT01-PivotalTracker


  @deleteAllProjects @deleteAllBoards
  Scenario: C66
  Verify that a new project is added on a INFO in M2 when it is created on PT
    When I add a info widget with the PROJECT option
      |   |   |
    And I click project Save button
    Then Verify all information displayed in the widget

  @deleteAllProjects @deleteAllBoards
  Scenario: C65-C127-C128-C129-C130-C131-C132-C133
  Verify all project information into INFO widget is displayed in Mach2
  The listed test cases Ids are executed into this scenario, this scenario cover all of them.
    When I add a info widget with the PROJECT option
      |  |  |
    And I click project Save button
    And I add all columns
    Then Verify all information displayed in the widget