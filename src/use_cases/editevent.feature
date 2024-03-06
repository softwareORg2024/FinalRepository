Feature: edit event


Scenario: User navigates to the event details page
Given the user is logged in
And there exists an event created by the user "salma"
When the user select an event 1 to edit it
Then the event details are displayed

Scenario: User edits the event name
Given the user is on the event details page
When the user select 1 to edit
And user "salma" modifies the event name of event "omar's birthday" to "asma Birhday"
Then the event name is updated successfully

Scenario: User changes the event location
Given the user is on the event details page
When the user select 2 to edit
And user "salma" modifies the event location of event "omar's birthday" to 2
Then the event location is updated successfully

Scenario: User updates the event date
Given the user is on the event details page
When the user select 3 to edit
And user "salma" modifies the event date of event "omar's birthday" to date 2024-03-25
Then the event date are updated successfully


  Scenario: User updates the event time
    Given the user is on the event details page
    When the user select 4 to edit
    And user "salma" modifies the event  time of event "omar's birthday" to  time 5:00:00
    Then the event and time are updated successfully



Scenario: User adjusts the number of attendees for the event
Given the user is on the event details page
When the user select 5 to edit
And  user "salma" modifies the number of attendees in event "omar's birthday" to 80
Then the number of attendees for the event is updated successfully

Scenario: User changes the theme of the event
Given the user is on the event details page
When the user select 6 to edit
And  user "salma" modifies the event theme in event "omar's birthday" to "frozen"
Then the event theme is updated successfully

Scenario: User adds additional services to the event
Given the user is on the event details page
When the user select 7 to edit
  And  user "salma" modifies the event "omar's birthday"
Then the services appear

Scenario: User removes a service from the event
Given the user is on the event details page
When the user select 8 to edit
  And  user "salma" delete from event "omar's birthday" the service with id 2
Then the selected service is removed from the event

Scenario: User cancels the selected package
Given the user is on the event details page
When the user select 9 to edit
  And user "abd" select to remove from event "abd's Birthday" the package
Then the selected package  is removed from the event


Scenario: User views events created by them
Given the user is logged in
When the user select 10 to edit
  And user "salma" to add
Then a list of events created by the user is displayed


Scenario: User deletes an existing event
Given the user is logged in
When the user select 11 to edit
  And user "rawand" to delete event "rawand's Birthday"
  Then the selected event is deleted from the user's events list

  Scenario: User edit the selected package
    Given the user is on the event details page
    When the user select 12 to edit
    And user "abd" select to edit from event "abd's Birthday" to add 1 Package
    Then the selected package  is edited from the event

