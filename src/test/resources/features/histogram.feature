@Feature
Feature: Histogram

  Scenario Outline: Hover over and bar selection

    Given Histogram view is opened
    When Hover over a bar with <index>
    Then Check boundaries and number of orders are displayed
    And Click on the bar with <index>

    Examples:
      | index |
      | 0     |
      | 1     |