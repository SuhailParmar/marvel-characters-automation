@context:API
Feature: Requesting marvel characters

  Scenario: Requesting a list of Marvel Character IDs
    Given I am an unauthenticated user
    When I request a list of marvel characters
    Then a list of user IDs are returned

  Scenario: Getting a specific Marvel character
    Given I am an unauthenticated user
    When I request a Marvel character by ID
    Then a Marvel character is returned

  Scenario: Fail to find a Marvel character
    Given I am an unauthenticated user
    When I request a Marvel character which does not exist
    Then I am notified the character is not found

  Scenario: Bad request when providing an ID of 0
    Given I am an unauthenticated user
    When I request a Marvel character with ID 0
    Then I am notified of a bad request

  Scenario: Bad request when providing a negative integer
    Given I am an unauthenticated user
    When I request a Marvel character with ID -1
    Then I am notified of a bad request