@Feature
Feature:  Scatter-plot

  Scenario Outline: Check Attributes and Intervals change

    When Scatter-plot view is opened
    Then Change X Attribute to <X Attribute>
    And check  name of the X-axis changed to <X Attribute>
    Then Change Y Attribute to <Y Attribute>
    And check  name of the Y-axis changed to <Y Attribute>
    Then Change interval to <Intervals>
    And check <Intervals> points are shown on the Scatter-plot

    Examples:
      | X Attribute | Y Attribute            | Intervals |
      | Exec size   | Realized market impact | 10        |
