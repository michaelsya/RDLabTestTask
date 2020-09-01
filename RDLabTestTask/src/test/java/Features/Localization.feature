Feature: Change User Interface Language

  Scenario Outline: essential web element names are changed according to the language choice
    Given I am on any page
    When I change the language to <language_name>
    Then essential web elements appear in <language_name>
    Examples:
      | language_name |
      | English       |
      | Suomi         |
      | Svenska       |