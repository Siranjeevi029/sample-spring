#!/usr/bin/env bash

# Install Java 21 (Amazon Corretto)
curl -fsSL https://apt.corretto.aws/corretto.key | sudo tee /etc/apt/trusted.gpg.d/corretto.asc
echo 'deb https://apt.corretto.aws stable main' | sudo tee /etc/apt/sources.list.d/corretto.list
sudo apt update && sudo apt install -y java-21-amazon-corretto-jdk

# Build the Spring Boot app
./mvnw clean package -DskipTests
