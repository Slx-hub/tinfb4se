# Test plan

## 1.	Introduction
### 1.1	Purpose
The purpose of the Iteration Test Plan is to gather all of the information necessary to plan and control the test effort for a given iteration. 
It describes the approach to testing the software.
This Test Plan for vnv supports the following objectives:
-	Identifies the items that should be targeted by the tests.
-	Identifies the motivation for and ideas behind the test areas to be covered.
-	Outlines the testing approach that will be used.
-	Identifies the required resources and provides an estimate of the test efforts.
### 1.2	Scope
This document describes the used tests, as they are unittests and functionality testing.
### 1.3	Intended Audience
This document is meant for internal use primarily.
### 1.4	Document Terminology and Acronyms
- **SRS**	Software Requirements Specification
- **n/a**	not applicable
- **tbd**	to be determined
### 1.5	 References
- [GitHub](https://github.com/SlaxXxX/tinfb4se)
- [Blog](https://tinfb4se.wordpress.com/)
- [Overall Use case diagram](https://github.com/SlaxXxX/tinfb4se/blob/master/projectFiles/OverallUseCaseDiagram.png)
- [Software Requirements Specification](https://github.com/SlaxXxX/tinfb4se/blob/master/projectFiles/SoftwareRequirementsSpecification.md)
- [Software Architecture Document](https://github.com/SlaxXxX/tinfb4se/blob/master/projectFiles/SoftwareArchitectureDocument.md)
- [UC Alter Path](https://github.com/SlaxXxX/tinfb4se/blob/master/projectFiles/useCases/Alter%20Path.md)
- [UC Close Game](https://github.com/SlaxXxX/tinfb4se/blob/master/projectFiles/useCases/Close%20Game.md)
- [UC Move Camera](https://github.com/SlaxXxX/tinfb4se/blob/master/projectFiles/useCases/Move%20Camera.md)
- [UC Navigate Menu](https://github.com/SlaxXxX/tinfb4se/blob/master/projectFiles/useCases/Navigate%20Menu.md)
- [UC Place Tower](https://github.com/SlaxXxX/tinfb4se/blob/master/projectFiles/useCases/Place%20Tower.md)
- [UC Place Unit](https://github.com/SlaxXxX/tinfb4se/blob/master/projectFiles/useCases/Place%20Unit.md)
- [UC Save Level](https://github.com/SlaxXxX/tinfb4se/blob/master/projectFiles/useCases/Save%20Level.md)
- [UC Select Level](https://github.com/SlaxXxX/tinfb4se/blob/master/projectFiles/useCases/Select%20Level.md)
### 1.6 Document Structure
tbd
## 2.	Evaluation Mission and Test Motivation
### 2.1	Background
By testing our project, we make sure that all changes to the sourcecode do not break the functionality. Also by integrating the test process in our deployment process, we make sure that only working versions of our project getting deployed. So the web application is always available.
### 2.2	Evaluation Mission
Our motivation in implementing tests came at an early stage to recognize the need for errors and to ensure the functionality and thus the outstanding quality of the software.
### 2.3	Test Motivators
Our motivation in implementing tests came at an early stage to recognize the need for errors and to ensure the functionality and thus the outstanding quality of the software.
Our testing is motivated by 
- quality risks 
- technical risks, 
- use cases 
- functional requirements
## 3.	Target Test Items
The listing below identifies those test items (software, hardware, and supporting product elements) that have been identified as targets for testing. This list represents what items will be tested. 
Items for Testing:
- java backend
- UI (Android-App & Desktop-Launcher)
- local installation
## 4.	Outline of Planned Tests
### 4.1	Outline of Test Inclusions
Unit testing of the java backend and functional testing of the user-interface aswell as a installationtest from a user.
### 4.2	Outline of Other Candidates for Potential Inclusion
Integrationtesting of key elements that work on a wider scope are potential test szenarios aswell but these are not in scope if our current testing process.
### 4.3 Outline of Test Exclusion
tbd
## 5.	Test Approach
### 5.1 Initial Test-Idea Catalogs and other Rference Sources
### 5.2	Testing Techniques and Types
#### 5.2.1	Function and Database Integrity Testing
n/a
#### 5.2.2	Unit Testing
|| |
|---|---|
|Technique Objective  	| Exercise functionality of model functions. Test for right data entry and right data output. |
|Technique 		|  Execute JUnit Test functions in our test classes |
|Oracles 		|  Each test expect the right value given in the assertequals function |
|Required Tools 	|  JUnit Test |
|Success Criteria	|    Testcoverage > ?%      |
|Special Considerations	|     -          |
#### 5.2.3	Business Cycle Testing
n/a
#### 5.2.4	User Interface Testing
Automated with use of Cucumber and Feature-Files
#### 5.2.5	Performance Profiling 
n/a
#### 5.2.6	Load Testing
n/a
#### 5.2.7	Stress Testing
n/a
#### 5.2.8	Volume Testing
n/a
#### 5.2.9	Security and Access Control Testing
n/a
#### 5.2.10	Failover and Recovery Testing
n/a
#### 5.2.11	Configuration Testing
n/a
#### 5.2.12	Installation Testing
n/a
#### 5.2.13 User Acceptance Testing
UAT as so called pre-Alpha-Tests with a few users testing the game in the current state to play it before release and give constructive feedback. A conclusion of these Tests can be found [here](https://de.surveymonkey.com/stories/SM-CQQ75H9V/).

## 6.	Entry and Exit Criteria
### 6.1	Test Plan
#### 6.1.1	Test Plan Entry Criteria
Building a new version of the software will execute the testprocess.
#### 6.1.2	Test Plan Exit Criteria
When all tests pass without throwing an exception.
#### 6.1.3 Suspension and Resumption Criteria
n/a
### 6.2 Test Cycles
#### 6.2.1 Test Cycle Entry Critria
n/a
#### 6.2.2 Test Cycle Exit Criteria
n/a
#### 6.2.3 Test Cycle Abnormal Termination
n/a
## 7.	Deliverables
### 7.1	Test Evaluation Summaries
To see the implementation of sonarcloud-services click [here](https://sonarcloud.io/dashboard?id=SlaxXxX_tinfb4se).
### 7.2	Reporting on Test Coverage
To see the implementation of sonarcloud-services click [here](https://sonarcloud.io/component_measures?id=SlaxXxX_tinfb4se&metric=Coverage).</br>
Note that there is an unknown issue with the coverage at the moment. There is a fair amount of tests and they got a 100% succes rate but coverage still is 0,0%.
### 7.3	Perceived Quality Reports
To see the implementation of sonarcloud-services click [here](https://sonarcloud.io/component_measures?id=SlaxXxX_tinfb4se&metric=Maintainability).
### 7.4	Incident Logs and Change Requests
n/a
### 7.5	Smoke Test Suite and Supporting Test Scripts
n/a
### 7.6	Additional Work Products
n/a
#### 7.6.1	Detailed Test Results
n/a
#### 7.6.2	Additional Automated Functional Test Scripts
n/a
#### 7.6.3	Test Guidelines
- One test-class contains test for only one class that needs to be tested
- The test-class should have the same name as the class to be tested with the Addition "Test" at the end (ex. MyClass -> MyClassTest)
- The test-functions should be named so one can see its purpose without the need of looking into the implementation. It should contain the name of the tested function, the testcase and the expected outcome. (ex. "setSpeed_canNotBeNegative_speedShouldBeUnchanged()").
#### 7.6.4	Traceability Matrices
n/a
## 8.	Testing Workflow
n/a
## 9.	Environmental Needs
[This section presents the non-human resources required for the Test Plan.]
### 9.1	Base System Hardware
tbd
### 9.2	Base Software Elements in the Test Environment
AndroidStudio & JUnit4
### 9.3	Productivity and Support Tools
n/a
### 9.4 Test Environment Configurations
n/a
## 10.	Responsibilities, Staffing, and Training Needs
### 10.1	People and Roles
This table shows the staffing assumptions for the test effort.

Human Resources


| Role | Minimum Resources Recommended (number of full-time roles allocated) |	Specific Responsibilities or Comments |
|---|---|---|
| Test Manager | 1 | Provides management oversight. <br> Responsibilities include: <br> planning and logistics <br> agree mission <br> identify motivators<br> acquire appropriate resources<br> present management reporting<br> advocate the interests of test<br>evaluate effectiveness of test effort |
| Test Designer | 1 | Defines the technical approach to the implementation of the test effort. <br> Responsibilities include:<br> define test approach<br> define test automation architecture<br> verify test techniques<br> define testability elements<br> structure test implementation|
| Tester | 1 |	Implements and executes the tests.<br> Responsibilities include:<br> implement tests and test suites<br> execute test suites<br> log results<br> analyze and recover from test failures<br> document incidents|
| Test System Administrator | 1 | Ensures test environment and assets are managed and maintained.<br> Responsibilities include:<br> 	administer test management system<br> install and support access to, and recovery of, test environment configurations and test labs | 
| Implementer | 3| Implements and unit tests the test classes and test packages.<br> Responsibilities include:<br> creates the test components required to support testability requirements as defined by the designer |
### 10.2	Staffing and Training Needs
tbd
## 11.	Iteration Milestones
n/a
## 12. Risks, Dependencies, Assumptions, and Constrains
n/a
## 13. Management, Process and Procedures
### 13.1 Measuring and Assessing the Extent of Testing
n/a
### 13.2 Assessing the Deliverables of this Test Plan
n/a
### 13.3 Problem Reporting, Escalation, and Issue Resolution
n/a
### 13.4 Managing Test Cycles
n/a
### 13.5 Traceability Strategies
n/a
### 13.6 Approval and Signoff
n/a
