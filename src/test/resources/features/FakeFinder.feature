@FakeFinder

Feature: Find the fake gold bar

  Scenario: Identify and click the fake gold bar
    Given I am on the gold bar challenge page
    When I weigh the gold bars to find the fake one
    Then I should see the alert with the message "Yay! You find it!"
    And I should see the list of weighings