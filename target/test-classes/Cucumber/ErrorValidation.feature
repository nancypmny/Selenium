
@tag
Feature: Error Validation
  I want to use this template for my feature file

  @ErrorValidation
  Scenario Outline: Title of your scenario outline
    Given I landed on Ecommerce page
    When logged in with username <name> and password <password>
    Then "Incorrect email or password" message is display
 
    Examples: 
      | name                   | password          | 
      |  rahulshetty@gmail.com | Iamking@00012     | 