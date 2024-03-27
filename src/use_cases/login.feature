Feature: login

  Scenario: valid login
    Given I am not in system
    When set username "haya" and pass "123"
    Then login succeed


  Scenario: invalid user name
    Given I am not in system
    When set invalid username "hayak" and pass "123"
    Then login failed


  Scenario Outline: invalid pass
    Given I am not in system
    When set valid username <user_name> and invalid pass <pass>
    Then login failed
    Examples:
      | user_name | pass    |
      | "haya"    | "12349" |
      | "naa"    | "Forget" |
      | "nay"    | "1234" |
      | "haya"    | "Forget" |



  Scenario Outline: blank user name
    Given I am not in system
    When set empty username <user_name> and pass <pass>
    Then login failed
    Examples:
      | user_name | pass   |
      | ""        | "1234" |
      | "sara"        | "" |
      | "sara"        | "1234" |
      | ""        | "" |

  Scenario Outline: blank pass
    Given I am not in system
    When set valid username <user_name> and empty pass <pass>
    Then login failed
    Examples:
      | user_name | pass |
      | "haya"    | ""   |
      | ""        | "1234" |
      | ""        | "" |
      | "haya"        | "1234" |


  Scenario Outline: User Forgot Password
    Given I am not in system
    When set valid username <user_name> and  pass <pass>
    Then take new pass <newPass>
    Examples:
      | user_name | pass     | newPass |
      | "haya"    | "Forget" | "12345" |
      | "haa"    | "Forget" | "12345" |
      | "haya"    | "Fort" | "12345" |

  Scenario Outline: User needs to Create Account
    Given I am not in system
    And i don't have an account
    When set new username <string> and pass <string2> and bd=<string3> and phone numbr=<string4> and email=<string5>
    Then create succeed
    Examples:
      | string | string2 | string3    | string4      | string5          |
      | "adam" | "54321" | "7\3\2004" | "0594507933" | "haya@gmail.com" |
      | "adm" | "1234" | "7\3\2004" | "0594507933" | "haya@gmail.com" |
      | "salma" | "1234" | "7\3\2004" | "0594507933" | "haya@gmail.com" |
      | "salma" | "11" | "7\3\2004" | "0594507933" | "haya@gmail.com" |


  Scenario Outline: Service provider needs to Create Account
    Given I am not in system
    And i don't have an account
    When set new username <string> and pass <string2> and bd=<string3> and sType=<string4> and phone numbr=<string5> and email= <string6>
    Then create succeed
    Examples:
      | string | string2 | string3    | string4        | string5      | string6          |
      | "eman" | "54321" | "7\3\2004" | "photographer" | "0594507933" | "eman@gmail.com" |
      | "eman" | "21" | "7\3\2004" | "photographer" | "0594507933" | "eman@gmail.com" |
      | "pllp" | "05321" | "7\3\2004" | "photographer" | "0594507933" | "eman@gmail.com" |

  Scenario Outline: Service provider needs to Create Account
    Given I am not in system
    And i don't have an account
    When set new username <string> and pass <string2> and bd=<string3> and sType=<string4> and phone numbr=<string5> and email= <string6>
    Then create succeed
    Examples:
      | string | string2 | string3    | string4        | string5      | string6          |
      | "jana" | "54321" | "7\3\2004" | "photographer" | "0594507933" | "eman@gmail.com" |


  Scenario Outline: User needs to Create Account
    Given I am not in system
    And i don't have an account
    When set new username <string> and pass <string2> and bd=<string3> and phone numbr=<string4> and email=<string5>
    Then create succeed
    Examples:
      | string | string2 | string3    | string4      | string5          |
      | "zaid" | "54321" | "7\3\2004" | "0594507933" | "haya@gmail.com" |

  Scenario: create empty person
    Given I am not in system
    And i don't have an account
    When create empty person
    Then created empty person succeed

  Scenario: create empty person
    Given I am not in system
    And i don't have an account
    When create empty person
    Then created empty person succeed
