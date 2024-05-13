@activity4
Feature: Login Test

  @SmokeTest
  Scenario: Testing Login without Examples
    Given User is on 4 Login page
    When User enters "admin" and "password"
    Then Read the page title and confirmation message on page
    And Close the login browser