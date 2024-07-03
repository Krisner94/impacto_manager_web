FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y

COPY src/pom.xml .
COPY src src

RUN apt-get install -y maven
RUN mvn clean install

FROM openjdk:17-jdk-slim

EXPOSE 8080

COPY --from=build /target/impacto_manager_web-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]