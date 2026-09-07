Feature: OrangeHRM Admin Page

  Background:
    Given User launches ORangeHRM application
    When  User enters username
    And User enters the password
    And User clicks on login button
    Then User verify the Dashboard page


  Scenario Outline: To Search the user with Status in Admin page
    When User navigates to Admin module
    Then Search with user "<status>"
    Then Click on Search button
    And Validate the fields with "<status>"

    Examples:
    |status |
    |Enabled|

  Scenario Outline: To Search the user with User Role in Admin page
    When User navigates to Admin module
    Then Search with user role "<role>"
    Then Click on Search button


    Examples:
      |role |
      |Admin|

    Scenario Outline: To Add a user in admin page
      When User navigates to Admin module
      Then User click on Add button
      Then Search with user role "<role>"
      Then User inputs Employee name
      Then Search with user "<status>"
      Then User enter username
      Then User provide input to the password field
      Then User enter the Confirm password
      And Click on Save button

      Examples:
      | role | status |
      |Admin | Enabled|

  Scenario Outline: To Search the user in Admin page
    When User navigates to Admin module
    Then Search with Admin "<username>"
    Then Click on Search button
   # Then Validate the fields with "<status>"
    Then User Clicks on edit
    Then Click on Save button
    Then Search with Admin "<username>"
    Then click on Delete button
    Examples:
      |status |username |
      |Enabled|Adminst  |