# 1 Use-Case Name

Alter Path

## 1.1 Brief Description
The use case allows the user to edit a level.

# 2 Flow of Events

## 2.1 Basic Flow

From the editor screen the user can click on buttons and on tiles:

Case 1: "Save" button is clicked

- User is moved to the level save screen

Case 2: "Back" button is clicked

- User is moved to the Display level selection Screen

Case 3: "Add" button is clicked

- additive Mode for the editor screen is activated

Case 4: "Remove" button is clicked 

- additive Mode for the editor screen is deactivated

Case 5: tile is Clicked

    Case 5.1 additive mode is activated

      Case 5.1.1 selected tile is located next to existing path:

      - add tile to path

      Case 5.1.2 selected tile is not located next to existing path:

      - do nothing

    Case 5.2 addidate mode is deactivated 

      Case 5.2.1 selected tile is located at the end or start of a path:

      - remove tile from path

      Case 5.2.2 selected tile is not located at the end or start of a path:

      - do nothing


### 2.1.1 Activity Diagram

![alt text][ActivityDiagram]

[ActivityDiagram]: https://github.com/SlaxXxX/tinfb4se/blob/master/projectFiles/useCases/alterPathAD.png "Activity Diagram"

### 2.1.2 Mock-up

![alt text][Mock]

[Mock]: https://github.com/SlaxXxX/tinfb4se/blob/master/projectFiles/useCases/alterPath_mock.png "Mock-up"

### 2.1.3 Narrative

n/a

## 2.2 Alternative Flows

n/a

# 3 Special Requirements

n/a

# 4 Preconditions

User clicks on the level editor button.

# 5 Postconditions

n/a

# 6 Extention Points

n/a

#### To get back to the SRS click [here](https://github.com/SlaxXxX/tinfb4se/blob/master/projectFiles/SoftwareRequirementsSpecification.md)
