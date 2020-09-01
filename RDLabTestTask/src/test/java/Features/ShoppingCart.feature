Feature: possibility to add and remove items from shopping cart

  Background:
    Given I am on products page
    And shopping cart is empty

  Scenario: I add a new product to the  cart
    When I select "Blue Duck" in the "Popular" product list
    And I set  the quantity to 1
    And add the product to the cart
    Then Shopping cart widget displays the correct price and quantity

  Scenario: I change the product quantity in the cart
    Given I have a "Red Duck" in the cart with quantity set to 1
    When I set the product quantity to 5
    And hit "Update" button
    Then the product quantity should be 5
    And the price is calculated properly

  Scenario: I remove a product from the shopping using Remove button
    Given I have a "Red Duck" in the cart with quantity set to 1
    When hit "Remove" button
    Then the cart is empty









    When I select "Red Duck" in the "Latest" product list
    And I set the quantity to 1
    And I add the product to the cart
    And I navigate to the cart
    Then the product quantity should be 1
    When I set the product quantity to 5
    And hit "Update" button
    Then the product quantity should be 5
    And the price is calculated properly