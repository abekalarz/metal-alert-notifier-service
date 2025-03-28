# metal-alert-notifier-service

This is backend part of the application which is responsible for defining templates for metal alert notifications.

# Getting Started

## To run backend all what is needed is to run below commands:
1. Open project within your favourite IDE (e.g. free Intelij IDEA Community edition).
2. From project folder run `docker-compose up -d` (which will download image of MongoDB database and run as container).
3. Find root application class named `MetalAlertNotifierServiceApplication.java` and simply run it directly from Intelij IDEA (right click on the file and click `Run...`)
4. Optional: if you found any issues with running in point 3. then please try to use this command directly from terminal in root project directory `mvn spring-boot:run`.

# Technologies used:
1. Java in version 21.
2. Spring Boot starters in version 3.4.4. 
3. MongoDB database in version 7.x
4. Build automation and dependency management: Maven 4.0.0
