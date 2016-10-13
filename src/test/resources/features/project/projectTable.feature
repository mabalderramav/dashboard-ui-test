@deleteAllServices @addPivotalTrackerService
Feature: Project table widget

  Background: Create a Project in pivotal and synchronize with Mach2
    Given I send a POST request with list to /projects
      | name              | iteration_length | week_start_day | point_scale | start_date | number_of_done_iterations_to_show | initial_velocity |
      | AT - 01 project01 | 1                | Monday         | 0,1,2,3     | 2016-08-29 | 12                                | 10               |
      | AT - 01 project02 | 1                | Monday         | 0,1,2,3,5,8 | 2016-09-05 | 12                                | 10               |

    And Synchronize Mach2 with Pivotal Tracker description AT01-PivotalTracker

  @deleteAllProjects @deleteAllBoards
  Scenario: C13-C29-C30-C31-C32-C33-C34-C35
    Verify that ALL Projects from PT are displayed when adding the TABLE widget
    The listed test cases Ids are executed into this scenario, this scenario cover all of them.
    When I add a table widget with the PROJECT option
      |  |  |
    And I click Save button
    Then All displayed projects should be the same that I sent in the request
    And I expect the columns size should be the by default
    And Validate project table against pivotal project