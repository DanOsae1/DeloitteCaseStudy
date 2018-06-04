# Deloitte digital away day
##Day event scheduler application :spiral_calendar_pad:
A software tool that assists event planners with organising activities for teams at the digital away day.

###Design
This application has been designed and built to recieve data in the form of a text file, that contains event activites and their durations and provide a scheduled timetable for the given number of Team participants.

If the activities list data is not supplied the application has a pre-populated list of activities to schedule and will default the number of teams participating to two.

The output is stored on the user's home directory. 

###Assumptions

  - The tasks within the activities.txt file will always be in the format of "Event Title (duration)mins".

  - The number of activities in the list may change.

  - The number of teams participating in the digital away day may change.


###Running the application

  Go to the root of the application.
  ``` mvn clean install 
  ```
  
  Go to target folder and the runnable .jar file.
  ``` java -jar target/Deloitte_Digital_Away_Day-jar-with-dependencies.jar
  ```

  You will be prompted to either load the default file or to supply a new one.

  Then, a prompt to define how many teams will participate.




