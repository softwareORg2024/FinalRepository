Feature: Admin Management

  Scenario: Admin views list of all registered users
    Given the admin is logged in
    When the admin selects 1
    And the user list created
    Then the list of all registered users in the application is displayed

  Scenario: Admin views list of all service providers
    Given the admin is logged in
    When the admin selects 2
    And the service provider list created
    Then the list of all service providers in the application is displayed

  Scenario: Admin views list of all event
    Given the admin is logged in
    When the admin selects 3
    And the event list created
    Then the list of all event in the application is displayed

  Scenario: Admin creates a new ready-made package
    Given the admin is logged in
    When the admin selects 4
    And adds the description of an event " Golden Event " and the cost 100.00 and id 5
    Then the new ready-made package is created successfully

  Scenario: Admin deletes an existing ready-made package
    Given the admin is logged in
    And there exist ready-made packages in the application
    When the admin selects 5
    And selects 1 To delete
    Then the selected package is deleted successfully

  Scenario: Admin views list of all packages
    Given the admin is logged in
    When the admin selects 6
    And the package list created
    Then the list of all package in the application is displayed