Feature: Test the correct functioning of the page, create your monster

  Scenario: Validate the creation of a monster
    Given I entered the page create your monster
    When I add a monster with the following data
      | Number of monster | Name  | HP  | Attack | Defense | Speed |
      | 2                 | Bruce | 100 | 90     | 80      | 50    |
    Then It is valid for the monster to appear of the list


  Scenario: Validate the elimination of a monster
    Given I entered the page create your monster
    And I add a monster with the following data
      | Number of monster | Name  | HP  | Attack | Defense | Speed |
      | 2                 | Bruce | 100 | 90     | 80      | 50    |
    When I eliminate the monster
    Then It should not appear on the list


  Scenario: Validate the attempt to create a monster with empty fields
    Given I entered the page create your monster
    When I try to create a monster with empty fields
    Then an error will appear indicating that I must complete all of the fields


  Scenario: Validate the creation of various monster
    Given I entered the page create your monster
    When I add the monsters with the data
      | Number of monster | Name  | HP  | Attack | Defense | Speed |
      | 2                 | Bruce | 100 | 90     | 80      | 50    |
      | 2                 | Bruce | 100 | 90     | 80      | 50    |
    Then I must see the created monsters in the list