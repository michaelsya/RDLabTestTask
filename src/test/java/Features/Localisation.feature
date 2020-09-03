Feature: Change User Interface Language

  @123
  Scenario Outline: essential web element names are changed according to the language choice I make
    Given I am on home page
    When I change the "Language" to "<language_name>"
    Then essential web elements appear in "<language_name>"
    Examples:
      | language_name |
      | English       |
      | Suomi         |
      | Svenska       |