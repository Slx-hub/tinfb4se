# Software Requirements Specification

# For Tower Attack

### By CodeCrunch
#### Version <1.0>

### Revision History

<table border="1" cellspacing="0" cellpadding="0" style="border-collapse:collapse;
 border:none;">

<tbody>

<tr>

<td width="154" valign="top" style="width:1.6in;border:solid windowtext .75pt;
  padding:0in 5.4pt 0in 5.4pt">

**Date**

</td>

<td width="77" valign="top" style="width:.8in;border:solid windowtext .75pt;
  border-left:none;padding:0in 5.4pt 0in 5.4pt">

**Version**

</td>

<td width="250" valign="top" style="width:2.6in;border:solid windowtext .75pt;
  border-left:none;padding:0in 5.4pt 0in 5.4pt">

**Description**

</td>

<td width="154" valign="top" style="width:1.6in;border:solid windowtext .75pt;
  border-left:none;padding:0in 5.4pt 0in 5.4pt">

**Author**

</td>

</tr>

<tr>

<td width="154" valign="top" style="width:1.6in;border:solid windowtext .75pt;
  border-top:none;padding:0in 5.4pt 0in 5.4pt">

20/10/2018

</td>

<td width="77" valign="top" style="width:.8in;border-top:none;border-left:none;
  border-bottom:solid windowtext .75pt;border-right:solid windowtext .75pt;
  padding:0in 5.4pt 0in 5.4pt">

1.0

</td>

<td width="250" valign="top" style="width:2.6in;border-top:none;border-left:none;
  border-bottom:solid windowtext .75pt;border-right:solid windowtext .75pt;
  padding:0in 5.4pt 0in 5.4pt">

<details>

</td>

<td width="154" valign="top" style="width:1.6in;border-top:none;border-left:none;
  border-bottom:solid windowtext .75pt;border-right:solid windowtext .75pt;
  padding:0in 5.4pt 0in 5.4pt">

Kai Schwark

</td>

</tr>

<tr>

<td width="154" valign="top" style="width:1.6in;border:solid windowtext .75pt;
  border-top:none;padding:0in 5.4pt 0in 5.4pt"></td>

<td width="77" valign="top" style="width:.8in;border-top:none;border-left:none;
  border-bottom:solid windowtext .75pt;border-right:solid windowtext .75pt;
  padding:0in 5.4pt 0in 5.4pt"></td>

<td width="250" valign="top" style="width:2.6in;border-top:none;border-left:none;
  border-bottom:solid windowtext .75pt;border-right:solid windowtext .75pt;
  padding:0in 5.4pt 0in 5.4pt"></td>

<td width="154" valign="top" style="width:1.6in;border-top:none;border-left:none;
  border-bottom:solid windowtext .75pt;border-right:solid windowtext .75pt;
  padding:0in 5.4pt 0in 5.4pt"></td>

</tr>

<tr>

<td width="154" valign="top" style="width:1.6in;border:solid windowtext .75pt;
  border-top:none;padding:0in 5.4pt 0in 5.4pt"></td>

<td width="77" valign="top" style="width:.8in;border-top:none;border-left:none;
  border-bottom:solid windowtext .75pt;border-right:solid windowtext .75pt;
  padding:0in 5.4pt 0in 5.4pt"></td>

<td width="250" valign="top" style="width:2.6in;border-top:none;border-left:none;
  border-bottom:solid windowtext .75pt;border-right:solid windowtext .75pt;
  padding:0in 5.4pt 0in 5.4pt"></td>

<td width="154" valign="top" style="width:1.6in;border-top:none;border-left:none;
  border-bottom:solid windowtext .75pt;border-right:solid windowtext .75pt;
  padding:0in 5.4pt 0in 5.4pt"></td>

</tr>

<tr>

<td width="154" valign="top" style="width:1.6in;border:solid windowtext .75pt;
  border-top:none;padding:0in 5.4pt 0in 5.4pt"></td>

<td width="77" valign="top" style="width:.8in;border-top:none;border-left:none;
  border-bottom:solid windowtext .75pt;border-right:solid windowtext .75pt;
  padding:0in 5.4pt 0in 5.4pt"></td>

<td width="250" valign="top" style="width:2.6in;border-top:none;border-left:none;
  border-bottom:solid windowtext .75pt;border-right:solid windowtext .75pt;
  padding:0in 5.4pt 0in 5.4pt"></td>

<td width="154" valign="top" style="width:1.6in;border-top:none;border-left:none;
  border-bottom:solid windowtext .75pt;border-right:solid windowtext .75pt;
  padding:0in 5.4pt 0in 5.4pt"></td>

</tr>

</tbody>

</table>

**<span style="font-size:18.0pt;font-family:Arial;">  
</span>**

Table of Contents

[1. <span style="font-size:12.0pt"></span> Introduction](#1\.                  Introduction)         

[1.1 <span style="font-size:12.0pt"></span> Purpose](#1.1     Purpose)     

[1.2 <span style="font-size:12.0pt"></span> Scope](#1.2     Scope)     

[1.3 <span style="font-size:12.0pt"></span> Definitions, Acronyms and Abbreviations](#1.3     Definitions, Acronyms and Abbreviations)     

[1.4 <span style="font-size:12.0pt"></span> References](#1.4     References)     

[1.5 <span style="font-size:12.0pt"></span> Overview](#1.5     Overview)     

[2. <span style="font-size:12.0pt"></span> Overall Description](#2\.                  Overall Description)    

[3. <span style="font-size:12.0pt"></span> Specific Requirements](#3\.                  Specific Requirements)

[3.1 <span style="font-size:12.0pt"></span> Functionality](#3.1     Functionality)

[3.1.1 <span style="font-size:12.0pt"></span> <Functional Requirement One>](#3.1.1     <Functional Requirement One>)        

[3.2 <span style="font-size:12.0pt"></span> Usability  ](#3.2               Usability)   

[3.2.1 <span style="font-size:12.0pt"></span> <Usability Requirement One>](#3.2.1          <Usability Requirement One>)

[3.3 <span style="font-size:12.0pt"></span> Reliability](#3.3     Reliability)     

[3.3.1 <span style="font-size:12.0pt"></span> <Reliability Requirement One>](#3.3.1          <Reliability Requirement One>)

[3.4 <span style="font-size:12.0pt"></span> Performance](#3.4     Performance)     

[3.4.1 <span style="font-size:12.0pt"></span> <Performance Requirement One>](#3.4.1          <Performance Requirement One>)

[3.5 <span style="font-size:12.0pt"></span> Supportability](#3.5     Supportability)     

[3.5.1 <span style="font-size:12.0pt"></span> <Supportability Requirement One>](#3.5.1          <Supportability Requirement One>)

[3.6 <span style="font-size:12.0pt"></span> Design Constraints](#3.6     Design Constraints)     

[3.6.1 <span style="font-size:12.0pt"></span> <Design Constraint One>](#3.6.1          <Design Constraint One>)

[3.7 <span style="font-size:12.0pt"></span> Online User Documentation and Help System Requirements](#3.7     On-line User Documentation and Help System Requirements)     

[3.8<span style="font-size:12.0pt"></span> Purchased Components](#3.8     Purchased Components)     

[3.9 <span style="font-size:12.0pt"></span> Interfaces](#3.9     Interfaces)     

[3.9.1 <span style="font-size:12.0pt"></span> User Interfaces ](#3.9.1          User Interfaces)          

[3.9.2 <span style="font-size:12.0pt"></span> Hardware Interfaces](#3.9.2          Hardware Interfaces)           

[3.9.3 <span style="font-size:12.0pt"></span> Software Interfaces](#3.9.3          Software Interfaces)           

[3.9.4 <span style="font-size:12.0pt"></span> Communications Interfaces](#3.9.4          Communications Interfaces)           

[3.10 <span style="font-size:12.0pt"></span> Licensing Requirements ](#3.10     Licensing Requirements)    

[3.11 <span style="font-size:12.0pt"></span> Legal, Copyright and Other Notices](#3.11     Legal, Copyright, and Other Notices)     

[3.12 <span style="font-size:12.0pt"></span> Applicable Standards](#3.12     Applicable Standards)     

[4. <span style="font-size:12.0pt"></span> Supporting Information](#4\.                  Supporting Information)    

Software Requirements Specification

# <a name="1\.                  Introduction">1.<span style="font:7.0pt &quot;Times New Roman&quot;"></span> Introduction</a>

## <a name="1.1     Purpose">1.1<span style="font:7.0pt &quot;Times New Roman&quot;"></span> Purpose</a>

This SRS describes the Android game “Tower Attack”. It contains a comprehensive list of all its requirements. This includes both requirements for the listed functionalities but also internal, nonfunctional requirements of the project.

## <a name="1.2     Scope">1.2<span style="font:7.0pt &quot;Times New Roman&quot;"></span> Scope</a>

“Tower Attack” will be an inverted single-player tower-defense game which means it’s a tower-defense game where you take the role of the attacker, not the tower-building defender. 

## <a name="1.3     Definitions, Acronyms and Abbreviations">1.3<span style="font:7.0pt &quot;Times New Roman&quot;"></span> Definitions, Acronyms and Abbreviations</a>

n/a: Not Applicable
<br/>Play Store: Google Play Store 
<br/>tbd: to be determined

## <a name="1.4     References">1.4<span style="font:7.0pt &quot;Times New Roman&quot;"></span> References</a>

Android Studio: https://developer.android.com/studio/
<br/>GIT: https://git-scm.com/
<br/>GitHub: https://github.com/
<br/>Google Play Store: https://play.google.com/store

## <a name="1.5     Overview">1.5<span style="font:7.0pt &quot;Times New Roman&quot;"></span> Overview</a>

The following Chapters describe our vision for the project, the requirements for it, the conventions we want to develop it with and the technical realization of this project.

# <a name="2\.                  Overall Description">2.<span style="font:7.0pt &quot;Times New Roman&quot;"></span> Overall Description</a>

Tower Attack will be a game in the Tower-Defense genre. In contrast to other games of the Tower-Defense genre you won’t place the turrets to hold your base against incoming enemy waves but try to carry your minions through the towers placed by the computer enemy. The goal is to traverse the enemy base by manipulating the preset path and upgrading the capabilities of your pawns.

#diagram here -------------------------

# <a name="3\.                  Specific Requirements">3.<span style="font:7.0pt &quot;Times New Roman&quot;"></span> Specific Requirements</a>

## <a name="3.1     Functionality">3.1<span style="font:7.0pt &quot;Times New Roman&quot;"></span> Functionality</a>

### <a name="3.1.1     <Functional Requirement One>">3.1.1<span style="font:7.0pt &quot;Times New Roman&quot;"></span> Working Main Menu</a>

There should be a main menu where the player can choose between different options like “play” or “options”.

### <a name="3.1.2     <Functional Requirement Two>">3.1.2<span style="font:7.0pt &quot;Times New Roman&quot;"></span> Start and load games<Functional Requirement Two></a>

The game itself should start after the player chooses “play” in the main menu.

### <a name="3.1.3     <Functional Requirement Three>">3.1.3<span style="font:7.0pt &quot;Times New Roman&quot;"></span> Send and upgrade units<Functional Requirement Three></a>

The player should be able to send units and upgrade them.

### <a name="3.1.4     <Functional Requirement Four>">3.1.4<span style="font:7.0pt &quot;Times New Roman&quot;"></span> Choose between different unit types<Functional Requirement Four></a>

The player should be able to choose between different types of units to send.

### <a name="3.1.5     <Functional Requirement Four>">3.1.5<span style="font:7.0pt &quot;Times New Roman&quot;"></span> Use special abilities and spells<Functional Requirement Four></a>

The player should be able to use special abilities and spells.

### <a name="3.1.6     <Functional Requirement Six>">3.1.6<span style="font:7.0pt &quot;Times New Roman&quot;"></span> Damage the enemy base<Functional Requirement Six></a>

Units that reach the enemy base should damage it.

## <a name="3.2               Usability">3.2<span style="font:7.0pt &quot;Times New Roman&quot;"></span> Usability</a>

### <a name="3.2.1          <Usability Requirement One>">3.2.1<span style="font:7.0pt &quot;Times New Roman&quot;"></span> Easy to understand <Usability Requirement One></a>

The Player should understand what he is doing and how the game is played by just looking at the game and short explanations.

### <a name="3.2.2          <Usability Requirement One>">3.2.2<span style="font:7.0pt &quot;Times New Roman&quot;"></span> Easy to use <Usability Requirement One></a>

The app should be easy to use. The player should not be distracted by unnecessary information while playing. There should just be the right amount of information, so the player is able to understand what is going on while enjoying the game.

## <a name="3.3     Reliability">3.3<span style="font:7.0pt &quot;Times New Roman&quot;"></span> Reliability</a>

### <a name="3.3.1          <Reliability Requirement One>">3.3.1<span style="font:7.0pt &quot;Times New Roman&quot;"></span> Stable Android App <Reliability Requirement One></a>

The Android App should not crash at any point in a running game.

## <a name="3.4     Performance">3.4<span style="font:7.0pt &quot;Times New Roman&quot;"></span> Performance</a>

### <a name="3.4.1          <Performance Requirement One>">3.4.1<span style="font:7.0pt &quot;Times New Roman&quot;"></span> Justifiable Loading-Time <Performance Requirement One></a>

The time needed to start the game and to load in the game should be justifiable considering given hardware.

### <a name="3.4.2          <Performance Requirement One>">3.4.2<span style="font:7.0pt &quot;Times New Roman&quot;"></span> Smooth gameplay <Performance Requirement One></a>

The game should run smoothly without lags on not only the latest devices.

## <a name="3.5     Supportability">3.5<span style="font:7.0pt &quot;Times New Roman&quot;"></span> Supportability</a>

### <a name="3.5.1          <Supportability Requirement One>">3.5.1<span style="font:7.0pt &quot;Times New Roman&quot;"></span> Android <Supportability Requirement One></a>

Android is a commonly used OS primarily for mobile devices.

### <a name="3.5.2          <Supportability Requirement One>">3.5.2<span style="font:7.0pt &quot;Times New Roman&quot;"></span> PC <Supportability Requirement One></a>

Any OS that is capable of running a Java Runtime Environment

## <a name="3.6     Design Constraints">3.6<span style="font:7.0pt &quot;Times New Roman&quot;"></span> Design Constraints</a>

tbd

## <a name="3.7     On-line User Documentation and Help System Requirements">3.7<span style="font:7.0pt &quot;Times New Roman&quot;"></span> On-line User Documentation and Help System Requirements</a>

tbd

## <a name="3.8     Purchased Components">3.8<span style="font:7.0pt &quot;Times New Roman&quot;"></span> Purchased Components</a>

tbd

## <a name="3.9     Interfaces">3.9<span style="font:7.0pt &quot;Times New Roman&quot;"></span> Interfaces</a>

tbd

### <a name="3.9.1          User Interfaces">3.9.1<span style="font:7.0pt &quot;Times New Roman&quot;"></span> User Interfaces</a>

tbd

### <a name="3.9.2          Hardware Interfaces">3.9.2<span style="font:7.0pt &quot;Times New Roman&quot;"></span> Hardware Interfaces</a>

tbd

### <a name="3.9.3          Software Interfaces">3.9.3<span style="font:7.0pt &quot;Times New Roman&quot;"></span> Software Interfaces</a>

tbd

### <a name="3.9.4          Communications Interfaces">3.9.4<span style="font:7.0pt &quot;Times New Roman&quot;"></span> Communications Interfaces</a>

tbd

## <a name="3.10     Licensing Requirements">3.10<span style="font:7.0pt &quot;Times New Roman&quot;"></span> Licensing Requirements</a>

tbd

## <a name="3.11     Legal, Copyright, and Other Notices">3.11<span style="font:7.0pt &quot;Times New Roman&quot;"></span> Legal, Copyright, and Other Notices</a>

tbd

## <a name="3.12     Applicable Standards">3.12<span style="font:7.0pt &quot;Times New Roman&quot;"></span> Applicable Standards</a>

tbd

# <a name="4\.                  Supporting Information">4.<span style="font:7.0pt &quot;Times New Roman&quot;"></span> Supporting Information</a>

n/a

</div>
