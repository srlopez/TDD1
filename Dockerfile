FROM maven:3.9-eclipse-temurin-17 AS build

WORKDIR /workspace
COPY pom.xml .
COPY src ./src
RUN mvn -B package

FROM eclipse-temurin:17-jre

WORKDIR /app
COPY --from=build /workspace/target/tdd1-1.0-SNAPSHOT.jar /app/app.jar

ENTRYPOINT ["java", "-cp", "/app/app.jar", "com.example.App"]