@deleteAllServices @addPivotalTrackerService
Feature: Story table Test

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
      | AT - 01 story02 | started       | 3        | feature    |
      | AT - 01 story03 | started       | 3        | feature    |

    And Synchronize Mach2 with Pivotal Tracker description AT01-PivotalTracker

  @deleteAllProjects @deleteAllBoards
  Scenario: C147-C148-C149-C150-C151_Verify all story information into TABLE widget is displayed in Mach2
    When I add a table widget with the STORY option
      | PROJECTS  | AT01 project-01 |
      | ITERATION | IT 7            |
    And I click Save button
    Then Validate story table against pivotal story
