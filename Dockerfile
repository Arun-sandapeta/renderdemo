# Stage 1: Build
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
# Download dependencies in advance to leverage Docker's layer caching
RUN mvn dependency:go-offline

# Copy the source code and build the application
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run
FROM openjdk:17-jdk-alpine
WORKDIR /app

# Copy the built jar from the build stage
COPY --from=build /app/target/springdemo-0.0.1-SNAPSHOT.jar springboot.jar

# Add metadata
LABEL authors="Arun Kumar Sandapeta"

# Run the application
ENTRYPOINT ["java", "-jar", "/app/springboot.jar"]
