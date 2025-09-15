FROM eclipse-temurin:19-jdk-alpine

COPY backend/target/backend-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
