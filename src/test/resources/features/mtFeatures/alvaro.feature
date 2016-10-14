@deleteAllServices @addPivotalTrackerService
Feature: StoryItems Table and Info Test
  Background: Preconditions for StoryItems Table and Info
    Given I send a POST request to /projects
      | name                              | testito    |
      | iteration_length                  | 1          |
      | week_start_day                    | Monday     |
      | point_scale                       | 0,1,2,3    |
      | start_date                        | 2016-08-29 |
      | number_of_done_iterations_to_show | 12         |
      | initial_velocity                  | 10         |

    And I store as Project1
    And Synchronize Mach2 with Pivotal Tracker description Hello its me

  @deleteAllProjects @deleteAllBoards
  Scenario: Verify that all Iterations from a Project are displayed in the StoryItems TABLE widget wizard
    When I add a table widget with the STORY option
      | PROJECTS | testito |
    Then Verify the iterations quantity testito

  @deleteAllProjects @deleteAllBoards
  Scenario: Verify that all Iterations from a Project are displayed in the StoryItems INFO widget wizard
    When I add a info widget with the STORY option
      | PROJECTS | testito |
    Then Verify the iterations quantity testito