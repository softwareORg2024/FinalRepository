Feature: Role-Based Authentication and Task Display

  Scenario: Admin logs in and views admin tasks
    Given I am in system
    When the admin enter 1
    Then you can see admin menu

  Scenario: User logs in and views user tasks
    Given I am in system
    When the user enter 2
    Then You can see user menu


  Scenario: Service provider logs in and views service provider tasks
    Given I am in system
    When the service provider enter 3
    Then You can see service provider menu










