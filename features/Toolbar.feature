Feature:Toolbar

  Scenario: ToolbarSearchOption
    Given launch plaid app
    When click "search" button on toolbar
    #this function doesn't work. When I click the search button the app is closing


  Scenario: ToolbarChangeThemeOption
    Given launch plaid app
    When click "theme" button on toolbar

  Scenario: ToolbarFilterMenuOption
    Given launch plaid app
    When click "filter" button on toolbar
    Then check filter menu options are shown

   Scenario: ToolbarMoreOptionsOption
     Given launch plaid app
     When click "options" button on toolbar
     Then check options menu shown