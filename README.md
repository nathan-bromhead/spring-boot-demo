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
An identical version running in Docker can be found at http://ec2-13-59-231-80.us-east-2.compute.amazonaws.com
## Docker
The following steps will run the application on a Docker instance:
* Use the Dockerfile at the root of the project
* Build the project as detailed above
* Place the jar file and Dockerfile on your Docker server
* run the following : 
1. docker build -t sb-demo .
2. docker images --filter reference=sb-demo
3. docker run -e timezoneKey={TIMEZONE_KEY}  -p 80:8080 sb-demo
  
For step three, the assumption is that the container can listen on port 80, and if so, will route traffic from 80 to 8080.  

## Design Considrations
* Although arguably overkill for just this demo, from a design standpoint it makes more sense to have the controllers depend only on interfaces, as opposed to concrete classes, for their respective functionality.
* Same goes for the controllers returning instances of the IModel, although I'm breaking this rule slightly as the controllers do determine which implementation to return.

## Future Considerations

* API key storage: the project should use a solution like Valut to store the API key for the Timezone service - admittedly, the current solution of including when running it is a pain.
* Docker: instead of using the the built jar, I think the Dockerfile can pull the repo and build the jar
* Caching: If the _time/now_ endpoint were to be extended for allowing city names/codes, and the timezone service was swapped to the Google API, I believe you could cache all the relevant information about a city's timezone (daylight savings and UTC offset) and simply make the calculation to return to the user, instead of making the external call. For the math endpoint, it find it tough to argue for caching, unless it was determined that some combination of parameters were being passed in on a regular basis, in which case you could cache the result.