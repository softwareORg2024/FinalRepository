Feature: Notifications

  Scenario: Service Provider get email when user selects his service
    Given I'm the user
    When the user "mira" select service 2
    Then Send email to "s12112499@stu.najah.edu" with message "welcome"

  Scenario: user get email when he created the event successfully
    Given I'm the user
    When the user create event
    Then Send email to "mira.assi66@gmail.com" with message "welcome"