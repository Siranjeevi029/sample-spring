#!/usr/bin/env bash

# Update package lists and install OpenJDK 21
apt-get update && apt-get install -y openjdk-21-jdk

# Verify Java installation
java -version

# Build the Spring Boot app
./mvnw clean package -DskipTests
