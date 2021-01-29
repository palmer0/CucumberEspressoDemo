Feature: Hello

  @hello-feature
  Scenario: Start hello screen
    Given System starts hello screen
    Then I should see hello screen

  @hello-feature
  Scenario: Show hello screen
    Given I am on hello screen
    Then I should not see hello message

  @hello-feature
  Scenario: Tap hello button and show hello message
    Given I am on hello screen
    When I tap hello button
    Then I should see hello message