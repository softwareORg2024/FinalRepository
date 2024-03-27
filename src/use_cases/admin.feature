Feature: Admin Management

  Scenario: Admin views list of all registered users
    Given the admin is logged in
    When the admin selects
    And the user list created
    Then the list of all registered users in the application is displayed

  Scenario: Admin views list of all service providers
    Given the admin is logged in
    When the admin selects
    And the service provider list created
    Then the list of all service providers in the application is displayed

  Scenario: Admin views list of all event
    Given the admin is logged in
    When the admin selects
    And the event list created
    Then the list of all event in the application is displayed

  Scenario: Admin creates a new ready-made package
    Given the admin is logged in
    When the admin selects
    And adds the description of an event " Golden Event " and the cost 100.00 and id 5
    Then the new ready-made package is created successfully

  Scenario Outline: Admin deletes an existing ready-made package
    Given the admin is logged in
    And there exist ready-made packages in the application
    When the admin selects
    And selects <int1> To delete
    Then the selected package is deleted successfully
    Examples:
      | int1 |
      | 1    |
      | 45    |

  Scenario: Admin views list of all packages
    Given the admin is logged in
    When the admin selects
    And the package list created
    Then the list of all package in the application is displayed