Feature: Provide useful links to other areas of the website that the user may want to visit when they reach
  end of the page

  @Smoke
  Scenario: I click on the link in the footer area and the corresponding page opens
    Given I am on home page
    When I click on the links in the footer area
    Then corresponding pages open