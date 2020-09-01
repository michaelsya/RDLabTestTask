Feature: Login and logout abilities

  Scenario: user can log in using existing valid account credentials
    When I enter $email in the email address field
    And I enter "password" in the password field
    Then I am redirected to home page as a logged in user