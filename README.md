# workSchedule program :)
## Table of contents
* [General info](#general-info)
* [Design Patterns](#design-patterns)
* [Technologies](#technologies)
* [Setup](#setup)

## General-info
* This excercise was developed on java programming language using Eclipse IDE.
* The goal of this exercise is to output a table containing pairs of employees and how often they have coincided in the office.

## Design Patterns:
* DAO (Data Access Objet) to get information from our file.
* MVC (Model-View-Controller) to set information, handle information and do some logic and show it to the user.

## Solution: 
* We slice each line read from our inputs file, we separate the employee and his schedule, internally the slicer function will create a key-value collection where we will take as key the day and its value will be the hours.
* This information will be converted into an employee object and we will return a list of employees, with their respective schedule.
* We will take 2 employees from the list and we will compare their schedules, in case of sharing hours, we will add that value in a variable and we will return the name of both employees and the number of hours they share.

## Technologies
Project is created with:
* Eclipse IDE version: 2022-06
* JRE System Library version: JavaSE -1.8 (jdk-17.0.3.1)

## Requirements to execute:
* Download the file from this repository.
* Have JavaSE -1.8 (jdk-17.0.3.1) installed in your computer.
* In case you want to add more inputs go to the inputs.txt file located in the "src/main/file/" folder.

## Setup
To run this project:

```
$ cd ../<any-folder>
$ git clone https://github.com/Zandresw95/workSchedule.git
after that open your Eclipse IDE
choose your workspace
Go to menu File/Open File... and search for workSchedule folder
Open the project
Right click on your project and select "Run As" and select "Java Application"
```
