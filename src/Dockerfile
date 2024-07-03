# Define a imagem base
FROM ubuntu:latest AS build
RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
COPY . .

RUN apt-get install maven -y
RUN mvn clean install

FROM openjdk:17-jdk-slim

ENV PORT=8080

# Expose a porta
EXPOSE $PORT

COPY --from=build /target/impacto_manager_web-0.0.1-SNAPSHOT.jar /app/

ENTRYPOINT ["java","-jar","app.jar"]