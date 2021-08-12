FROM openjdk:11.0.12-jre-slim-buster

# Copy config files and artifact.
COPY build/libs/armor-service-0.0.1-SNAPSHOT.jar armor-service.jar
COPY src/main/resources/application.properties config/application.properties

EXPOSE 8081

ENTRYPOINT ["java","-jar", "/armor-service.jar"]

