@Feature
Feature:  Summary Page

  Scenario:  check main components

    When user is on Home page
    Then Settings button is shown at the right top corner
    And Benchmark Selector control is shown at the top of the page
    And Application Toolbar with Summary, Grid & chart, Histogram, Scatter-plot and Reports tabs is shown
