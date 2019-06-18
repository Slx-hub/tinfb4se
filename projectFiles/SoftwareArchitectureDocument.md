# Software Architecture Document


## 1. Introduction

### 1.1	Purpose
This document provides a comprehensive architectural overview of the system, using a number of different architectural views to depict different aspects of the system. It is intended to capture and convey the significant architectural decisions which have been made on the system.

### 1.2	Scope
This document is closely related to the Software Requirement Specifications and it's defined Use Cases. You can find both in the GitHub repository of this Project (See 1.4: References). 
 
### 1.3	Definitions, Acronyms, and Abbreviations
* MVC = Model View Controller
* N.a = Not applicable

### 1.4	References
* Github Repository: https://github.com/SlaxXxX/tinfb4se
* Blog: https://tinfb4se.wordpress.com/

### 1.5	Overview
This Document contains information about our software architecture. In more details, you can find information about Architectural Representation, Architectural Goals and Constraints, Use-Case View,
Logical View, Process View, Deployment View, Implementation View, Data View, Size and Performance and Quality.

### 1.6 Tech Stack
* Java ver. 1.8
* JUnit ver. 4.12
* libGDX ver. 1.9.8
* Android ver. 28.0.3
* AndroidStudio ver. 3.3.2
* Graddle ver. 3.3.2
* GitHub
* YouTrack

## 2. Architectural Representation
This section describes what software architecture is for the current system. Our project is a plain Java application that interfaces with the user via two launchers. An android launcher and a desktop launcher.
The application was built after the MVC architecture.

## 3. Architectural Goals and Constraints
One constraint is set by our framework library - libGDX. View adapters are inheriting from Screen, that is more or less view and controller combined.
We solved it by just passing all controller calls coming from the framework over to our real controller.

## 4. Use-Case View
![alt text][UCD]

[UCD]: https://github.com/SlaxXxX/tinfb4se/blob/master/projectFiles/OverallUseCaseDiagram.png "Use Case Diagram"

## 5. Logical View

### 5.1 Overview
As we started our project with the MVC architecture in mind, we agreed to a naming convention that specifies in which part the class acts.
For example every class starting with V_ is part of the view etc.
This "tag" also contains information about the type of class, like A for abstract and E for enum.

Meaning of the "tags" used in the class-diagram:
* M_ : Model
* V_ : View
* C_ : Controller
* MA_ & VA_ & CA_ : Abstract classes
* ME_ & VE_ & CE_ : Enum classes

![alt text][ClassDiagram]

[ClassDiagram]: https://github.com/SlaxXxX/tinfb4se/blob/master/projectFiles/ClassDiagram.png "Class Diagram"
(Click image for full sise)

### 5.2	Architecturally Significant Design Packages
The diagrams below are all part of the class-diagram you can find in 5.1. We decided to cut the whole class-diagram into those pieces to make it less complicated to understand because the whole thing is really huge. The tags mentioned in 5.1 apply to those diagrams aswell. 
</br> this one shows the stuff around our mvc architecture to make everything work together witch the libGDX framework:

![alt text][ClassDiagramCollapsed]

[ClassDiagramCollapsed]: https://github.com/SlaxXxX/tinfb4se/blob/master/projectFiles/ClassDiagram_collapsed.png "Class Diagram Collapsed"

This diagram shows only our models:

![alt text][ClassDiagramModel]

[ClassDiagramModel]: https://github.com/SlaxXxX/tinfb4se/blob/master/projectFiles/ClassDiagram_model.png "Class Diagram Model"

In this one you can see our views:

![alt text][ClassDiagramView]

[ClassDiagramView]: https://github.com/SlaxXxX/tinfb4se/blob/master/projectFiles/ClassDiagram_view.png "Class Diagram View"

Here you can see our controllers:

![alt text][ClassDiagramController]

[ClassDiagramController]: https://github.com/SlaxXxX/tinfb4se/blob/master/projectFiles/ClassDiagram_controller.png "Class Diagram Controller"

## 6. Process View 
N.a


## 7. Deployment View 
N.a


## 8. Implementation View 

### 8.1 Overview
N.a

### 8.2 Layers
N.a


## 9. Data View
N.a


## 10. Size and Performance
The performance of the application will be affected by the number of towers and units that are currentl on the map and how powerful the hardware in use is. However the application was tested using very poor hardware and no flaws were found.


## 11. Quality
In order to maximize the efficiency of the development process for our project we are using Travis CI as a continous integration tool. With every commit to any branch, as well as periodically every day, a Travis CI build is triggered to run unit tests, in addition of doing a sonarcloud analysis on the project's source code. This way every project contributer is aware of the current integrity of the project's codebase, allowing for faster project iteration and thus making it easier to reach the project's goals.
