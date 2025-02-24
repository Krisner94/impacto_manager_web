FROM maven:3.9.6-amazoncorretto-21 AS build

COPY . /app
WORKDIR /app

RUN mvn clean generate-sources
RUN mvn clean package -DskipTests

FROM amazoncorretto:21-alpine

COPY --from=build /app/target/impacto_manager_web-0.0.1-alpha.jar impacto-manager.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "impacto-manager.jar"]