Feature: Select level

  As a User
  I want to select a level to play

  Scenario: Level selection aborted
    Given I "am" on the "/selectLevel" screen
    When I click on the "back" button
    Then I "get" on the "menu" screen

  Scenario: Level selection successful
    Given I "am" on the "/selectLevel" screen
    When I click on the level I want to play
    And The previous level "is" solved or first level
    Then I the selected level should start

  Scenario: Level selection unsuccessful
    Given I "am" on the "/selectLevel" screen
    When I click on the level I want to play
    And The previous level "is not" solved or first level
    Then I should see the "level needs to be unlocked" message
    And I "stay" on the "/selectLevel" screen

  Scenario: Level selection navigate up successful
    Given I "am" on the "/selectLevel" screen
    And I "am not" at the "top" of the List
    When I click on the "upperArrow" button
    Then I "stay" on the "/selectLevel" screen
    And I get to see the "next lower" levels

  Scenario: Level selection navigate up unsuccessful
    Given I "am" on the "/selectLevel" screen
    And I "am" at the "top" of the List
    When I click on the "upperArrow" button
    Then I "stay" on the "/selectLevel" screen
    And I get to see the "same" levels

  Scenario: Level selection navigate down successful
    Given I "am" on the "/selectLevel" screen
    And I "am not" at the "bottom" of the List
    When I click on the "lowerArrow" button
    Then I "stay" on the "/selectLevel" screen
    And I get to see the "next higher" levels

  Scenario: Level selection navigate down unsuccessful
    Given I "am" on the "/selectLevel" screen
    And I "am" at the "bottom" of the List
    When I click on the "lowerArrow" button
    Then I "stay" on the "/selectLevel" screen
    And I get to see the "same" levels

