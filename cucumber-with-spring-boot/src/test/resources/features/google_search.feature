@smoke
Feature: Google search

  @google # Defined under CucumberRunner
  Scenario Outline: Search for a keyword at Google
    Given I am on the google site
    When I enter "<keyword>" as a keyword
    Then I should see search results page
    Then I should see at least <count> results
    Then I quit the browser

    Examples:
      | keyword     | count       |
      | selenium    | 2           |
      | java        | 5           |
      | spring      | 37          |