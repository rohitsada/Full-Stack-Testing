@activity5
Feature: Login Test Extension

  @SmokeTest
  Scenario: Testing Login without Examples
    Given User is on 5 Login page
    When User enter "<Username>" and "<Password>"
    Then Read the page title and confirmation message on page5
    And Close the login browser5


    Examples:
      | Username | Password  |
      | admin    | password |
      | user2    | password2 |