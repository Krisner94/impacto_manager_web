FROM maven:3.8.5-openjdk-17 AS build
COPY . /app
WORKDIR /app
RUN mvn clean generate-sources
RUN mvn clean package -DskipTests

FROM openjdk:21-jdk-slim
COPY --from=build /app/target/impacto_manager_web-0.0.1-alpha.jar impacto-manager.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "impacto-manager.jar"]