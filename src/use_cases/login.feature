Feature: login

  Scenario: valid login
    Given I am not in system
    When set username "haya" and pass "123"
    Then login succeed


  Scenario: invalid user name
    Given I am not in system
    When set invalid username "hayak" and pass "123"
    Then login failed


  Scenario: invalid pass
    Given I am not in system
    When set valid username "haya" and invalid pass "1234"
    Then login failed


  Scenario: blank user name
    Given I am not in system
    When set empty username "" and pass "1234"
    Then login failed

  Scenario: blank pass
    Given I am not in system
    When set valid username "haya" and empty pass ""
    Then login failed

  Scenario: User Forgot Password
    Given I am not in system
    When set valid username "haya" and  pass "Forget"
    Then take new pass "12345"

  Scenario: User needs to Create Account
    Given I am not in system
    And i don't have an account
    When set new username "adam" and pass "54321" and bd="7\3\2004" and phone numbr="0594507933" and email="haya@gmail.com"
    Then create succeed

  Scenario: Service provider needs to Create Account
    Given I am not in system
    And i don't have an account
    When set new username "eman" and pass "54321" and bd="7\3\2004" and sType="photographer" and phone numbr="0594507933" and email= "eman@gmail.com"
    Then create succeed