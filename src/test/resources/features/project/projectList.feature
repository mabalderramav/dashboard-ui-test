Feature: Project widget

  Background: login
    Given I send a POST request with list to /projects
      | name              | iteration_length | week_start_day | point_scale | start_date | number_of_done_iterations_to_show | initial_velocity |
      | AT - 01 project01 | 1                | Monday         | 0,1,2,3     | 2016-08-29 | 12                                | 10               |
      | AT - 01 project02 | 1                | Monday         | 0,1,2,3,5,8 | 2016-09-05 | 12                                | 10               |

    And I expect the status code 200
    And Synchronize Mach2 with Pivotal Tracker and project AT01-PivotalTracker


  @deleteAllProjects @addPivotalTrackerService
  Scenario: T644 - Verify that ALL Projects from PT are displayed when adding the TABLE widget
    When I add a table widget in the board and I select the Project option
    Then I expect all displayed projects in Mach2 are the same that I sent in the request.
    And I expect the columns size should be the by default
    And Validate project table against pivotal project
