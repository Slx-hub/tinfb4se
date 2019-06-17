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

[UCD]: https://github.com/SlaxXxX/tinfb4se/blob/master/projectFiles/OverallUseCaseDiagram.png "Use Case Diagram"

# <a name="3. Specific Requirements">3. Specific Requirements</a>

The requirements are modeled in a use-case based system. The Overall Use Case Diagram as shown in the overall description contains all requirements that are set between the user and the application.

## <a name="3.1 Functionality">3.1 Functionality</a>

### <a name="3.1.1 Navigate menu">3.1.1 Navigate menu</a>

The navigation menu ist the first screen of the app. The user can choose from the navigation menu what he wants to do.
</br>For more detailed Information click [here](https://github.com/SlaxXxX/tinfb4se/blob/master/projectFiles/useCases/Navigate%20Menu.md)

### <a name="3.1.2 Alter settings">3.1.2 Alter settings</a>

The user can change the volume of sound effects and background music. In addition to that he can deactivate the push-notifications of the app.
</br>For more detailed Information click [here](https://github.com/SlaxXxX/tinfb4se/blob/master/projectFiles/useCases/Settings.md)

### <a name="3.1.3 Select level">3.1.3 Select level</a>

The user can choose from different levels and can select the one he wants to play. After he selected a level that is unlocked for playing, the level will start.
</br>For more detailed Information click [here](https://github.com/SlaxXxX/tinfb4se/blob/master/projectFiles/useCases/Select%20Level.md)

### <a name="3.1.4 Select level">3.1.4 Alter path</a>

The user can edit the path of levels in the editor.
</br>For more detailed Information click [here](https://github.com/SlaxXxX/tinfb4se/blob/master/projectFiles/useCases/Alter%20Path.md)

### <a name="3.1.5 Select level">3.1.5 Save level</a>

The user can save his created Level. Before saving, the created level will be checked for correctness.
</br>For more detailed Information click [here](https://github.com/SlaxXxX/tinfb4se/blob/master/projectFiles/useCases/Save%20Level.md)

### <a name="3.1.6 Place unit">3.1.6 Place unit</a>

The user should be able to send units onto the field.
</br>For more detailed Information click [here](https://github.com/SlaxXxX/tinfb4se/blob/master/projectFiles/useCases/Place%20Unit.md)

### <a name="3.1.7 Move camera">3.1.8 Move camera</a>

The user should be able to move the in-game camera.
</br>For more detailed Information click [here](https://github.com/SlaxXxX/tinfb4se/blob/master/projectFiles/useCases/Move%20Camera.md)

### <a name="3.1.8 Close game">3.1.9 Close game</a>

The user should be able to close a game and return to the menu.
</br>For more detailed Information click [here](https://github.com/SlaxXxX/tinfb4se/blob/master/projectFiles/useCases/Close%20Game.md)

### <a name="3.1.9 Place turret">3.1.9 Place turret</a>

The computer enemy should be able to place turrets on free spaces.
</br>For more detailed Information click [here](https://github.com/SlaxXxX/tinfb4se/blob/master/projectFiles/useCases/Place%20Tower.md)

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
Tested and developed for Android version 8.1 and higher.

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

[GitHub Repository](https://github.com/SlaxXxX/tinfb4se) - The up-to-date source Code of our projects
</br>[CodeCrunch Blog](https://tinfb4se.wordpress.com/) - News regarding our project
