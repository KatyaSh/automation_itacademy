@Feature
Feature: Grid & Chart

  @severity=normal
  Scenario: Check columns visibility

    When Grid & Chart view is opened
    Then Open Filter Configurator control
    And check/uncheck Filter checkbox and verify column display
    Then Open Tool panel
    And check/uncheck Tool panel checkbox and verify column display
    Then Open filter for Id column and switch to the 3rd tab
    And check/uncheck column checkbox and verify column display

  Scenario Outline: Check sort

    When Grid & Chart view is opened
    And delete sort filter if applied
    Then Click on the column <header> to apply sort
    And check asc sort button appears
    And Make sure the sort is applied  the column <header>
    Then Click on the column <header> to apply sort
    And check desc sort button appears
    And Make sure the desc sort is applied  the column <header>
    Then Click on the column <header> to apply sort
    And  Check the sort is reset on the column <header>

    Examples:
      | header            |
      | Avg fill price    |
      | Num of executions |
      | Type              |
      | Start time        |