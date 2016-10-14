@deleteAllServices @addPivotalTrackerService
Feature: example to validate test
  Background: Preconditions For Table Story
    Given I send a POST request to /projects
      | name                              | AT01 project-01 |
      | iteration_length                  | 1               |
      | week_start_day                    | Monday          |
      | point_scale                       | 0,1,2,3         |
      | start_date                        | 2016-08-29      |
      | number_of_done_iterations_to_show | 12              |
      | initial_velocity                  | 10              |

    And I store as Project1

    And I send a POST request with list to /projects/[Project1.id]/stories
      | name            | current_state | estimate | story_type |
      | AT - 01 story01 | started       | 2        | feature    |

    And I store as Story1

    And Synchronize Mach2 with Pivotal Tracker description AT01-PivotalTracker
    When I add a table widget with the STORY option
      | PROJECTS  | AT01 project-01 |
      | ITERATION | IT 7            |

    And I click story Save button

  @deleteAllProjects @deleteAllBoards
  Scenario: Verify it is possible to delete a Story
    When I send a DELETE request to /projects/[Project1.id]/stories/[Story1.id]
    Then Synchronize Mach2 with Pivotal Tracker description AT01-PivotalTracker
    And I expect an empty table story widget