Feature: Create Event

  Scenario: user enters the creation page
    Given the user in user page
    When the user enters the 1
    Then the user enters the creation page


  Scenario: User creates an event with a past date
    Given the user is on the event creation page
    When the user fills in the event details with a past date 2024-01-25
    Then the user receives an error message

  Scenario: User creates a new event with mandatory details
    Given the user is on the event creation page
    When the user "haya" fills in the event details including name " Laila's Birthday", place "home", time 5:00:00, date 2024-03-25, number of attendees 20, and theme "unicorn"
    Then the event is created successfully

  Scenario: User chooses between individual services and ready-made packages
    Given the user is presented with a choice between individual services and ready-made packages
    When the user selects an option by entering for individual services and other for ready-made packages
    Then the user's choice is captured

  Scenario Outline: User chooses between the different services
    Given the user chooses to select individual services
    When the user selects choice from the menu
    Then the user's choice is token
    Examples:
      | int1 |
      | 1    |
      | 2   |
      | 3   |
      | 4   |
      | 5   |

  Scenario: User chooses between the different services
    Given the user chooses to select individual services
    When the user selects choice from the menu
    Then the user's choice is not token

  Scenario: User selects food service for the event
    Given the user selects the food service
    When  the user selects 1 choice from the  food menu
    Then Add the selected food service provider details to the event


  Scenario: User selects entertainment service for the event
    Given the user selects the entertainment service
    When  the user selects 2 choice from the  entertainment menu
    Then Add the selected entertainment service provider details to the event



  Scenario: User selects decoration service for the event
    Given the user selects the decoration service
    When  the user selects 3 choice from the  decoration menu
    Then Add the selected decoration service provider details to the event


  Scenario: User selects photographer service for the event
    Given the user selects the photographer service
    When  the user selects 4 choice from the  photographer menu
    Then Add the selected photographer service provider details to the event

  Scenario: User chooses a ready-made package for the event
    Given the user is on the event creation page
    When the user selects to choose a ready-made package
    And the user selects  1 package
   Then the selected package details are added to the event


  Scenario: User creates a new event with mandatory details
    Given the user is on the event creation page
    When the user "haya" fills in the event details including name "asmaa", place "home", time 8:00:00, date 2024-02-29, number of attendees 25, and theme "frozen" and there is no conflict between time and location and place
    Then  reject event creation


  Scenario: User does not exist in the user linked list
    Given the user "JohnDoe" is not in the linked list
    When I check for "JohnDoe" in the linked list
    Then the system should report that the user does not exist



  Scenario: The specified service type does not exist
    Given a list of available service types
    When the service id 1 and type "Premium Support" is not in the list
    Then the system should report that the service type does not exist

