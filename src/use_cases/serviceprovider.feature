Feature: Manage Services as a Service Provider

  Scenario: Service provider adds a new service
    Given the service provider is logged in
    When the service provider selects
    And fills in the details including description "10 photo", price 20, and ID 5 and service provider "tala"
    Then the new service is added successfully

  Scenario: Service provider modifies an existing service
    Given the service provider is logged in
    When the service provider selects
    And edits the details of the service including description "9 photo ", price 23, and ID 4 and service provider "tala"
    Then the service is modified successfully


  Scenario Outline: Service provider deletes an existing service
    Given the service provider is logged in
    When the service provider selects
    And the service with id <int1> to delete it and service provider <string>
    Then the selected service is deleted successfully
    Examples:
      | int1 | string |
      | 3    | "ali"  |
  Scenario Outline: Service provider deletes an existing service
    Given the service provider is logged in
    When the service provider selects
    And the service with id <int1> to delete it and service provider <string>
    Then the selected service is not found
    Examples:
      | int1 | string |
      | 8  | "ali"  |


  Scenario: Service provider navigates to the list of users who chose their services
    Given the service provider is logged in
    When the service provider selects
   And his name is "tala" to see users and services
    Then the list of users who chose the service provider's services is displayed

  Scenario: Service provider navigates to the list of services
    Given the service provider is logged in
    When the service provider selects
  And his name is "tala"
    Then the list of services


