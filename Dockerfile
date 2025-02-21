FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean generate-sources
RUN mvn clean package -DskipTest

FROM maven:3.8.1-openjdk-17-slim
COPY --from=build /target/impacto_manager_web-0.0.1-alpha.jar impacto-manager.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar","impacto-manager.jar"]
