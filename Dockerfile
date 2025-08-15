# Use Java 21 JDK base image
FROM eclipse-temurin:21-jdk-jammy
LABEL authors="mohitvats"

# Set working directory
WORKDIR /app

# Copy the Spring Boot fat JAR
COPY target/Auto-Complete-0.0.1-SNAPSHOT.jar app.jar

# Expose port your app uses
EXPOSE 9090

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]


