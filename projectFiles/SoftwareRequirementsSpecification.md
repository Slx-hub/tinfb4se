# Software Requirements Specification

# For Tower Attack

### By CodeCrunch

# <a name="1. Introduction">1. Introduction</a>

## <a name="1.1 Purpose">1.1 Purpose</a>

This SRS describes the Android game “Tower Attack”. It contains a comprehensive list of all its requirements. This includes both requirements for the listed functionalities but also internal, nonfunctional requirements of the project.

## <a name="1.2 Scope">1.2 Scope</a>

“Tower Attack” will be an inverted single-player tower-defense game which means it’s a tower-defense game where you take the role of the attacker, not the tower-building defender. 

The subsytems can be categorized into the following scopes defined by the Overall Use Case Diagram which is presented in 3. [Specific Requirements](#3. )
## <a name="1.3 Definitions, Acronyms and Abbreviations">1.3 Definitions, Acronyms and Abbreviations</a>

n/a: Not Applicable
<br/>Play Store: Google Play Store 
<br/>tbd: to be determined

## <a name="1.4 References">1.4 References</a>

Android Studio: https://developer.android.com/studio/
<br/>GIT: https://git-scm.com/
<br/>GitHub: https://github.com/
<br/>Google Play Store: https://play.google.com/store

## <a name="1.5 Overview">1.5 Overview</a>

The following Chapters describe our vision for the project, the requirements for it, the conventions we want to develop it with and the technical realization of this project.

# <a name="2. Overall Description">2. Overall Description</a>

Tower Attack will be a game in the Tower-Defense genre. In contrast to other games of the Tower-Defense genre you won’t place the turrets to hold your base against incoming enemy waves but try to carry your minions through the towers placed by the computer enemy. The goal is to traverse the enemy base by manipulating the preset path and upgrading the capabilities of your pawns. Tower Attack will be developed in Java as an application that can run on both, Android and any desktop-based Java runtime environment. 

![alt text][UCD]

[UCD]: https://github.com/SlaxXxX/tinfb4se/blob/master/projectFiles/UseCase.png "Use Case Diagram"

# <a name="3. Specific Requirements">3. Specific Requirements</a>

The requirements are modeled in a use-case based system. The Overall Use Case Diagram as follows contains all requirements that are set between the user and the application.

## <a name="3.1 Functionality">3.1 Functionality</a>

### <a name="3.1.1 Run app">3.1.1 Run app</a>

The User should be able to run the application on his device.

### <a name="3.1.2 Alter settings">3.1.2 Alter settings</a>

The User should be able to alter the settings.
</br>For more detailed Information click [here](https://github.com/SlaxXxX/tinfb4se/blob/master/projectFiles/useCases/Settings.md)

### <a name="3.1.3 Close app">3.1.3 Close app</a>

The User should be able to close the application.

### <a name="3.1.4 Run game">3.1.4 Run game</a>

The User should be able to run the game.

### <a name="3.1.5 Select level">3.1.5 Select level</a>

The User should be able to select the level he wants to play.
</br>For more detailed Information click [here](https://github.com/SlaxXxX/tinfb4se/blob/master/projectFiles/useCases/Settings.md)

### <a name="3.1.6 Start level">3.1.6 Start level</a>

The User should be able to start a specific level.

### <a name="3.1.7 Return to menu">3.1.7 Return to menu</a>

The User should be able to return to menu.

### <a name="3.1.8 Move camera">3.1.8 Move camera</a>

The User should be able to move the in-game camera.

### <a name="3.1.9 Close game">3.1.9 Close game</a>

The user should be able to close a game.

## <a name="3.2 Usability">3.2 Usability</a>

### <a name="3.2.1 Easy to understand">3.2.1 Easy to understand</a>

The Player should understand what he is doing and how the game is played by just looking at the game and short explanations.

### <a name="3.2.2 Easy to use">3.2.2 Easy to use</a>

The app should be easy to use. The player should not be distracted by unnecessary information while playing. There should just be the right amount of information, so the player is able to understand what is going on while enjoying the game.

## <a name="3.3 Reliablitity">3.3 Reliability</a>

### <a name="3.3.1 Stable Android App">3.3.1 Stable Android App</a>

The application should not crash at any point in a running game.

## <a name="3.4 Performance">3.4 Performance</a>

### <a name="3.4.1 Justifiable Loading-Time">3.4.1 Justifiable Loading-Time</a>

The time needed to start the game and to load in the game should be justifiable considering given hardware.

### <a name="3.4.2 Smooth gameplay">3.4.2 Smooth gameplay</a>

The game should run smoothly without stuttering on not only the latest devices.

## <a name="3.5 Supportability">3.5 Supportability</a>

### <a name="3.5.1 Android">3.5.1 Android</a>

Android is a commonly used OS primarily for mobile devices.

### <a name="3.5.2 PC">3.5.2 PC</a>

Any OS that is capable of running a Java Runtime Environment.

## <a name="3.6 Design Constraints">3.6 Design Constraints</a>

The application has to be developed in Java as an application that can run on both, Android and any desktop-based Java runtime environment. 

## <a name="3.7 On-line User Documentation and Help System Requirements">3.7 On-line User Documentation and Help System Requirements</a>

tbd

## <a name="3.8 Purchased Components">3.8 Purchased Components</a>

n/a

## <a name="3.9 Interfaces">3.9 Interfaces</a>

tbd

### <a name="3.9.1 User Interfaces">3.9.1 User Interfaces</a>

tbd

### <a name="3.9.2 Hardware Interfaces">3.9.2 Hardware Interfaces</a>

tbd

### <a name="3.9.3 Software Interfaces">3.9.3 Software Interfaces</a>

tbd

### <a name="3.9.4 Communications Interfaces">3.9.4 Communications Interfaces</a>

tbd

## <a name="3.10 Licensing Requirements">3.10 Licensing Requirements</a>

tbd

## <a name="3.11 Legal, Copyright, and Other Notices">3.11 Legal, Copyright, and Other Notices</a>

tbd

## <a name="3.12 Applicable Standards">3.12 Applicable Standards</a>

tbd

# <a name="4. Supporting Information">4. Supporting Information</a>

n/a
