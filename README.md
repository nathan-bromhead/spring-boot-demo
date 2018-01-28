Spring Boot Demo
================

## Endpoints

GET: /math/add?n1=<numeric_param_1>&n2=<numeric_param_2> will return the sum of the two paramters, ie:
/math/add?n1=20&n2=30 will return a JSON value of {"sum":"50"}

Any integer or decimal value is valid, as are negative numbers.

POST: /math/add is similar to the GET request, but the form paramters in the POST body must be named 1 and 2.

GET: /time/now will return the current time and timezone for Calgary at the time of the request, ie:
/time/now will return a JSON value of {"timezone":"Mountain Standard Time","time":"2018-01-28 16:40:43","location":"Calgary"}


## Building
You can build the project by running ./gradlew bootRepackage on the command line from the root of the project. This will create a jar file in build/libs.

## Running
You can run the project using java -jar restful_service-0.0.1-SNAPSHOT.jar --timezoneKey=YOUR_API_KEY_HERE
For the timezonekey variable, you will need to aquire an api key from www.amdoren.com

## Live Demo
There is a live demo of this project at http://nathan-bromhead.us-east-2.elasticbeanstalk.com