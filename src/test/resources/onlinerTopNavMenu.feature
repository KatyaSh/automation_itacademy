Feature: Onliner top nav menu check

  Scenario Outline: the top nav category menu is shown when hovering it over

    Given open browser with Onliner Home page
    When user hovers over the root <Category> in the top nav
    Then <top category menu title> menu with subcategories is shown
    And <subcategories column1> are shown
    And <subcategories column2> are shown
    And <subcategories column3> are shown


    Examples:

      | Category        | top category menu title | subcategories column1 | subcategories column2 | subcategories column3 |
      | Автобарахолка   | Автобарахолка           | Отзывы об авто        | Минск                 | Audi                  |
      | Дома и квартиры | Продажа                 | Минск                 | 1-комнатные           | До 30 000 $           |






