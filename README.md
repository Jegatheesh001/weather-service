# weather-service
Weather Service API's

Swagger URL: http://localhost:8044/swagger-ui.html

Endpoints: 
 - http://localhost:8044/weather/v1/byCity?city=xxx
 - http://localhost:8044/weather/v1/byCoordinate?lat=8.1667&lon=77.4333
 - http://localhost:8044/auth/register
 

Installation Steps:
 - Install Lombok in IDE
 - Import maven project from GIT repository
 - Build the project
 - Run the Jar file from target folder
 - Double CLick and run the project or use java -jar xyz.jar

Schema:
 - weather_service
 
Table:
   CREATE TABLE `user_details` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(45) DEFAULT NULL,
  `user_email` varchar(45) DEFAULT NULL,
  `login_name` varchar(45) DEFAULT NULL,
  `login_password` varchar(45) DEFAULT NULL,
   PRIMARY KEY (`user_id`)
   ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
   