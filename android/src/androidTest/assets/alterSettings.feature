Feature: Alter settings

  I want to alter the current settings

  Scenario: alter settings aborted
    Given I "am" on the "settings" screen
    When I click on the "save" button
    Then I "get" on the "menu" screen

  Scenario: alter settings change music volume right successful
    Given I "am" on the "settings" screen
    And The "music" volume "is not" at "max"
    When I drag the "music" volume slider to the "right"
    Then The "music" volume should "rise"
    And The "music" volume slider should "move" "right"

  Scenario: alter settings change music volume right unsuccessful
    Given I "am" on the "settings" screen
    And The "music" volume "is" at "max"
    When I drag the "music" volume slider to the "right"
    Then The "music" volume should "stay"
    And The "music" volume slider should "not move" ""

  Scenario: alter settings change music volume left successful
    Given I "am" on the "settings" screen
    And The "music" volume "is not" at "min"
    When I drag the "music" volume slider to the "left"
    Then The "music" volume should "decrease"
    And The "music" volume slider should "move" "left"

  Scenario: alter settings change music volume left unsuccessful
    Given I "am" on the "settings" screen
    And The "music" volume "is" at "min"
    When I drag the "music" volume slider to the "left"
    Then The "music" volume should "stay the same"
    And The "music" volume slider should "not move" ""

  Scenario: alter settings change sound-effects volume right successful
    Given I "am" on the "settings" screen
    And The "sound-effects" volume "is not" at "max"
    When I drag the "sound-effects" volume slider to the "right"
    Then The "sound-effects" volume should "rise"
    And The "sound-effects" volume slider should "move" "right"

  Scenario: alter settings change sound-effects volume right unsuccessful
    Given I "am" on the "settings" screen
    And The "sound-effects" volume "is" at "max"
    When I drag the "sound-effects" volume slider to the "right"
    Then The "sound-effects" volume should "stay"
    And The "sound-effects" volume slider should "not move" ""

  Scenario: alter settings change sound-effects volume left successful
    Given I "am" on the "settings" screen
    And The "sound-effects" volume "is not" at "min"
    When I drag the "sound-effects" volume slider to the "left"
    Then The "sound-effects" volume should "decrease"
    And The "sound-effects" volume slider should "move" "left"

  Scenario: alter settings change sound-effects volume left unsuccessful
    Given I "am" on the "settings" screen
    And The "sound-effects" volume "is" at "min"
    When I drag the "sound-effects" volume slider to the "left"
    Then The "sound-effects" volume should "stay"
    And The "sound-effects" volume slider should "not move" ""

  Scenario: alter settings disable Push-Notifications successful
    Given I "am" on the "settings" screen
    And Push-Notifications are "enabled"
    And The check-box is "checked"
    When I click on the "push-notifications" button
    Then The check-box is "unchecked"
    And Push-Notifications are "disabled"

  Scenario: alter settings enable Push-Notifications successful
    Given I "am" on the "settings" screen
    And Push-Notifications are "disabled"
    And The check-box is "unchecked"
    When I click on the "push-notifications" button
    Then The check-box is "checked"
    And Push-Notifications are "enabled"