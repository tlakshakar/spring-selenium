@flight
Feature: Google Flight
  Scenario: Book Flight
    Given I am on the google flight site
    When The page is loaded
    Then I should see labels
    Then I quit the browser