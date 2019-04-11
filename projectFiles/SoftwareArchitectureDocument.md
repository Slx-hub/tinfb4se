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

### 4.1 Use-Case Realization
N.a


## 5. Logical View

### 5.1 Overview
As we started our project with the MVC architecture in mind, we agreed to a naming convention that specifies in which part the class acts.
For example every class starting with V_ is part of the view etc.
This "tag" also contains information about the type of class, like A for abstract and E for enum.

Meeing of the "tags" used in the class-diagram:
* M_ : Model
* V_ : View
* C_ : Controller
* MA_ & VA_ & CA_ : Abstract classes
* ME_ & VE_ & CE_ : Enum classes

![alt text][ClassDiagram]

[ClassDiagram]: https://github.com/SlaxXxX/tinfb4se/blob/master/projectFiles/ClassDiagram.png "Class Diagram"

### 5.2	Architecturally Significant Design Packages
N.a


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
N.a


## 11. Quality
N.a
