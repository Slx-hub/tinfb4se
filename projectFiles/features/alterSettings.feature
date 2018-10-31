Feature: Alter settings

  Scenario: alter settings aborted
    Given I am on the 'alter settings' screen
    When I click on the 'back' button
    Then I should get on the 'main menu' screen

  Scenario: alter settings change music volume right successful
    Given I am on the 'alter settings' screen
    And The music volume is not at maximum
    When I drag the slider to the right
    Then The music volume should rise
    And The slider should move to the right

  Scenario: alter settings change music volume right unsuccessful
    Given I am on the 'alter settings' screen
    And The music volume is at maximum
    When I drag the slider to the right
    Then The music volume should stay the same
    And The slider should not move

  Scenario: alter settings change music volume left successful
    Given I am on the 'alter settings' screen
    And The music volume is not at minimum
    When I drag the slider to the left
    Then The music volume should decrease
    And The slider should move to the left

  Scenario: alter settings change music volume left unsuccessful
    Given I am on the 'alter settings' screen
    And The music volume is at minimum
    When I drag the slider to the left
    Then The music volume should stay the same
    And The slider should not move

  Scenario: alter settings change sound-effects volume right successful
    Given I am on the 'alter settings' screen
    And The sound-effects volume is not at maximum
    When I drag the slider to the right
    Then The sound-effects volume should rise
    And The slider should move to the right

  Scenario: alter settings change sound-effects volume right unsuccessful
    Given I am on the 'alter settings' screen
    And The sound-effects volume is at maximum
    When I drag the slider to the right
    Then The sound-effects volume should stay the same
    And The slider should not move

  Scenario: alter settings change sound-effects volume left successful
    Given I am on the 'alter settings' screen
    And The sound-effects volume is not at minimum
    When I drag the slider to the left
    Then The sound-effects volume should decrease
    And The slider should move to the left

  Scenario: alter settings change sound-effects volume left unsuccessful
    Given I am on the 'alter settings' screen
    And The sound-effects volume is at minimum
    When I drag the slider to the left
    Then The sound-effects volume should stay the same
    And The slider should not move

  Scenario: alter settings disable Push-Notifications successful
    Given I am on the 'alter settings' screen
    And Push-Notifications are enabled
    And The check-box is checked
    When I click at the button 'Push-Notifications'
    Then The check-box is unchecked
    And Push-notifications are disabled

  Scenario: alter settings enable Push-Notifications successful
    Given I am on the 'alter settings' screen
    And Push-Notifications are disabled
    And The check-box is unchecked
    When I click at the button 'Push-Notifications'
    Then The check-box is checked
    And Push-notifications are enabled