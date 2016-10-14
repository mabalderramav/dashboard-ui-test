@deleteAllServices @addPivotalTrackerService
Feature: History Item table widget

  Background: Create a Project in pivotal and synchronize with Mach2
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
      | name                   | current_state | estimate | story_type |
      | MT - 01 Project widget | started       | 1        | feature    |

    And I store as Story1
    And Synchronize Mach2 with Pivotal Tracker description AT01-PivotalTracker
    When I add a table widget with the STORY option
      | PROJECTS  | AT01 project-01 |
      | ITERATION | IT 7            |
    And I click story Save button

  @deleteAllProjects @deleteAllBoards
  Scenario: C147-C148-C149-C150-C151_Verify all story information into TABLE widget is displayed in Mach2
    When I send a PUT request to /projects/[Project1.id]/stories/[Story1.id]
      | name          | MT - 01 xProject widget updated |
      | current_state | started                         |
      | estimate      | 1                               |
      | story_type    | feature                         |
    Then Synchronize Mach2 with Pivotal Tracker description AT01-PivotalTracker
    Then Validate story table against pivotal story