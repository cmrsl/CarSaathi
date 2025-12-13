# Java 17
FROM eclipse-temurin:17-jdk

# App directory
WORKDIR /app

# Copy files
COPY . .

# Build jar
RUN ./mvnw clean package -DskipTests

# Expose port (Render uses 10000 internally, but Spring will read env)
EXPOSE 8080

# Run app
CMD ["java", "-jar", "target/*.jar"]
