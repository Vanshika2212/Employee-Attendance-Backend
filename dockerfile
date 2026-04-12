# ---------- BUILD STAGE ----------
FROM maven:3.9-eclipse-temurin-17 AS build

WORKDIR /app

# Copy project files
COPY . .

# Build the project (skip tests for faster deploy)
RUN mvn clean package -DskipTests


# ---------- RUNTIME STAGE ----------
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy the generated JAR from build stage
COPY --from=build /app/target/*.jar app.jar

# Render provides PORT dynamically
EXPOSE 8080

# Start the application
ENTRYPOINT ["java", "-jar", "app.jar"]