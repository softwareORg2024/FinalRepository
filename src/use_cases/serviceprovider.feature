Feature: Manage Services as a Service Provider

  Scenario: Service provider adds a new service
    Given the service provider is logged in
    When the service provider selects 1
    And fills in the details including description "10 photo", price 20, and ID 5 and service provider "tala"
    Then the new service is added successfully

  Scenario: Service provider modifies an existing service
    Given the service provider is logged in
    When the service provider selects 2
    And edits the details of the service including description "9 photo ", price 23, and ID 4 and service provider "tala"
    Then the service is modified successfully


  Scenario: Service provider deletes an existing service
    Given the service provider is logged in
    When the service provider selects 3
    And the service with id 3 to delete it and service provider "ali"
    Then the selected service is deleted successfully

  Scenario: Service provider navigates to the list of users who chose their services
    Given the service provider is logged in
    When the service provider selects 4
   And his name is "tala" to see users and services
    Then the list of users who chose the service provider's services is displayed

  Scenario: Service provider navigates to the list of services
    Given the service provider is logged in
    When the service provider selects 5
  And his name is "tala"
    Then the list of services


