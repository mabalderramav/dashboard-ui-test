#@deleteAllProjects @deleteAllServices @addPivotalTrackerService
#Feature: Delete project - Table Widget
#
#  Background: create Project in pivotal tracker and synchronise with Mach2
#    Given I send a POST request to /projects
#      | name                              | AT01 project-01 |
#      | iteration_length                  | 1               |
#      | week_start_day                    | Monday          |
#      | point_scale                       | 0,1,2,3         |
#      | start_date                        | 2016-08-29      |
#      | number_of_done_iterations_to_show | 12              |
#      | initial_velocity                  | 10              |
#    And I store as Project1
#    And Synchronize Mach2 with Pivotal Tracker description AT01-PivotalTracker
#    And I add a table widget with the PROJECT option
#      |  |  |
#
#  @deleteAllBoards
#  Scenario: Verify a deleted project on PT, is not showed in the table widget on M2
#    Given I send a DELETE request to /projects/[Project1.id]
#    And Synchronize Mach2 with Pivotal Tracker description AT01-PivotalTracker
#    Then I expect an empty table project widget
#
#  @deleteAllProjects @deleteAllBoards
#  Scenario: Verify that the values on Points column in M2 is the same when the value is modified on PT
#    Given I send a PUT request to /projects/[Project1.id]
#      | point_scale | 0,1,2,3,5,8 |
#    And Synchronize Mach2 with Pivotal Tracker description AT01-PivotalTracker
#    Then Validate project table against last response pivotal project