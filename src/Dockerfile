FROM ubuntu:20.04 AS build

RUN apt-get update && apt-get install openjdk-17-jdk -y
COPY ../pom.xml .
COPY src /impacto_manager_web/app/src

RUN apt-get install -y maven
RUN mvn clean package

FROM openjdk:17-jdk-slim

COPY --from=build /target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]