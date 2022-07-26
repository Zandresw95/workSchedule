# workSchedule program :)

Solution: 
  We will use the DAO and MVC design patterns. We slice each line read from our inputs file, we separate the employee and his schedule, internally the slicer function will create a key-value collection where we will take as key the day and its value will be the hours.
This information will be converted into an employee object and we will return a list of employees, with their respective schedule.

  We will take 2 employees from the list and we will compare their schedules, in case of sharing hours, we will add that value in a variable and we will return the name of both employees and the number of hours they share.

Instructions to execute:
  Have Eclipse IDE 2022-06 installed.
  Have the JRE System Library (JavaSE -1.8 (jdk-17.0.3.1)).
  Download the file from this repository.
  In case you want to add more inputs go to the inputs.txt file located in the "src/main/file/" folder.
