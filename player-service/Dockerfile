FROM openjdk:11.0.12-jre-slim-buster

# Copy config files and artifact.
COPY build/libs/player-service-0.0.1-SNAPSHOT.jar player-service.jar
COPY src/main/resources/application.properties config/application.properties

EXPOSE 8082

ENTRYPOINT ["java","-jar", "/player-service.jar"]