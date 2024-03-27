Feature: Manage Services as a Service Provider

  Scenario Outline: Service provider adds a new service
    Given the service provider is logged in
    When the service provider selects
    And fills in the details including description <string>, price <int1>, and ID <int2> and service provider <string2>
    Then the new service is added successfully
    Examples:
      | string     | int1 | int2 | string2 |
      | "10 photo" | 20   | 5    | "tala"  |

  Scenario Outline: Service provider adds a new service
    Given the service provider is logged in
    When the service provider selects
    And fills in the details including description <string>, price <int1>, and ID <int2> and service provider <string2>
    Then the new service is doesnt added successfully(there is no service provider)
    Examples:
      | string     | int1 | int2 | string2 |
      | "10 photo" | 20   | 5    | "taa45554545lla" |




  Scenario Outline: Service provider modifies an existing service
    Given the service provider is logged in
    When the service provider selects
    And edits the details of the service including description <string>, price <int1>, and ID <int2> and service provider <string2>
    Then the service is modified successfully
    Examples:
      | string     | int1 | int2 | string2 |
      | "9 photo " | 23   | 4    | "tala"  |
      | "55" | 20   | 700   | "ali"  |

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


