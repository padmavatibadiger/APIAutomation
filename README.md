  1. Extract zip folder
  2. Import the project directory to Eclipse IDE
  3. Sync pom.xml (maven) to resolve library dependencies
  4. Install maven and add path to the environment variable
  5. Open command prompt and go to project path
  6. Check for maven version "mvn --version" and enter command "mvn clean"
  7. To execute test cases enter "mvn clean install"
  
 
   //Another way to run test cases
 
 1. Import project into Eclipse
 2. Go to pom.xml file right click on it and click on "maven build" or "maven test"
 3. Or go to testng.xml right click on it and select "1 TestNG Suite" to run the test cases
  
  
  * Added screenshots for all the api , the response got from postman
  
  Created run.bat file to run the test cases through jenkins. There need to specify the project path 
  