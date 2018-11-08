Feature: Select level

  Scenario: Level selection aborted
    Given I am on the 'select level' screen
    When I click on the 'back' button
    Then I should get on the 'main menu' screen

  Scenario: Level selection successful
    Given I am on the 'select level' screen
    When I click on the level I want to play
    And I solved the previous level or it is the first level
    Then I the selected level should start

  Scenario: Level selection unsuccessful
    Given I am on the 'select level' screen
    When I click on the level I want to play
    And I did not solve the previous level
    Then I should see the 'level needs to be unlocked' message
    And I stay at the 'select level' screen

  Scenario: Level selection navigate up successful
    Given I am on the 'select level' screen
    And I am not at the top of the List
    When I click on the upper arrow
    Then I stay on the 'select level' screen
    And I get to see levels wih a lower number

  Scenario: Level selection navigate up unsuccessful
    Given I am on the 'select level' screen
    And I am at the top of the List
    When I click on the upper arrow
    Then I get to see the 'select level' screen
    And I get to see the same levels

  Scenario: Level selection navigate down successful
    Given I am on the 'select level' screen
    And I am not at the bottom of the List
    When I click on the lower arrow
    Then I stay on the 'select level' screen
    And I get to see levels wih a higher number

  Scenario: Level selection navigate down unsuccessful
    Given I am on the 'select level' screen
    And I am at the bottom of the List
    When I click on the lower arrow
    Then I get to see the 'select level' screen
    And I get to see the same levels

