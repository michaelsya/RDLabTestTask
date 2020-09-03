Feature: Login and logout abilities

  Scenario: I can log in using existing valid account credentials
    Given I am on a login page
    When I enter "3360333@gmail.com" in the email address field
    And I enter "111111" in the password field  and try to login
    Then I get "You are now logged in" notification

  @Smoke
  Scenario Outline: I get an error if I try logging in using invalid credentials
    Given I am on a login page
    When I enter "<email>" in the email address field
    And I enter "<password>" in the password field  and try to login
    Then I see an error message that says "<errorMessageText>"
    Examples:
      | email             | password          | errorMessageText                                             |
      | invalid@email.com | 111111            | Wrong password or the account is disabled, or does not exist |
      | 3360333@gmail.com | incorrectpassword | Wrong password or the account is disabled, or does not exist |
      | 3360333@gmail.com |                   | You must provide both email address and password.            |
      |                   | 111111            | You must provide both email address and password.            |
      |                   |                   | You must provide both email address and password.            |