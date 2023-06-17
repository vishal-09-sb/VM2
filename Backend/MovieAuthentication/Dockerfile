# Use OpenJDK 11 as the base image
FROM openjdk:11-jdk-slim

VOLUME /tmp

# Copy the jar file to the image
COPY target/authorizationService-0.0.1-SNAPSHOT.jar app.jar

# Command to run the application
ENTRYPOINT ["java", "-jar", "/app.jar"]
