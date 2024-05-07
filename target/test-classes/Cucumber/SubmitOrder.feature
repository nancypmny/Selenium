
@tag
Feature: Purchase the order from Ecommerce website
  I want to use this template for my feature file
  
  Background : 
  Given I landed on Ecommerce page

  @Regression
  Scenario Outline: Positive test of submitting the order
    Given Logged in with username <name> and password <password>
    When I add a product <productName> to cart
    And checkout <productName> and Submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage
    

    Examples: 
      | name                   | password         | productName  |
      |  rahulshetty@gmail.com | Iamking@000      | ZARA COAT 3  |
     
