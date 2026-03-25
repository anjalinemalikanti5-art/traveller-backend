# Stage 1: Build the Spring Boot app
FROM maven:3.9.6-eclipse-temurin-17 AS build

# Set working directory
WORKDIR /app

# Copy only pom.xml first for dependency caching
COPY pom.xml .

# Download dependencies (offline mode)
RUN mvn dependency:go-offline

# Copy source code
COPY src ./src

# Build the application (skip tests to speed up)
RUN mvn clean package -DskipTests

# Stage 2: Create a lightweight runtime image
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy the jar built from Stage 1
COPY --from=build /app/target/*.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]