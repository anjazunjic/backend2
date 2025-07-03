# Koristi oficijalni OpenJDK image
FROM openjdk:17-jdk-slim

# Postavi radni direktorijum unutar kontejnera
WORKDIR /app

# Kopiraj JAR fajl iz lokalnog direktorijuma u Docker konteiner
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Izloži port koji aplikacija koristi (po defaultu Spring Boot koristi port 8080)
EXPOSE 8080

# Pokreni aplikaciju
ENTRYPOINT ["java", "-jar", "/app/app.jar"]