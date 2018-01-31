FROM java:8
VOLUME /tmp
EXPOSE 8080
ADD /target/restful_service-0.0.1-SNAPSHOT.jar restful_service-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "restful_service-0.0.1-SNAPSHOT.jar"]
