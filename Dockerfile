# Use official OpenJDK base image
FROM eclipse-temurin:21-jdk

# Set working directory
WORKDIR /app

# Copy everything into container
COPY . .

# Give permissions (fix Render’s mvnw problem)
RUN chmod +x mvnw

# Build the app
RUN ./mvnw clean package -DskipTests

# Run the app
CMD ["java", "-jar", "target/demo2-0.0.1-SNAPSHOT.jar"]
