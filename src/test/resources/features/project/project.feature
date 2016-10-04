Feature: Project widget

  Background: login
    Given I add a service
      | SERVICENAME | Pivotal Tracker                  |
      | TOKEN       | 51fff45c0e68ab45ed99ceabcae0057d |
      | DESCRIPTION | AT01-PivotalTracker              |

    And I send a POST request to /projects
      | name                              | AT01 project-01 |
      | iteration_length                  | 1               |
      | week_start_day                    | Monday          |
      | point_scale                       | 0,1,2,3         |
      | start_date                        | 2016-08-29      |
      | number_of_done_iterations_to_show | 12              |
      | initial_velocity                  | 10              |
    And I expect the status code 200
    And Synchronize Mach2 with Pivotal Tracker and project AT01-PivotalTracker
