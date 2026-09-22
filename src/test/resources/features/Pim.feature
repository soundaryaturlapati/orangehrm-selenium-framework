Feature: Orange HRM PIM module

  Background:
    Given User launches ORangeHRM application
    When  User enters username
    And User enters the password
    And User clicks on login button
    Then User verify the Dashboard page

  Scenario: Add Employee

    When User navigates to the PIM module
    And User clicks on Add Employee
    And User fills in the employee details
    And User clicks on Save
    Then User should see the new employee added to the list
