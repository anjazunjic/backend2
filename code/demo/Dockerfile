# Step 1: Build stage using Maven image
FROM maven:3.8.4-openjdk-17-slim AS builder

# Postavi radni direktorijum unutar kontejnera
WORKDIR /app

# Kopiraj sve fajlove u kontejner (celo backend2 repo)
COPY . .

# Pokreni Maven da izgradimo aplikaciju
RUN mvn clean install

# Step 2: Run stage - koristi manju sliku samo za pokretanje aplikacije
FROM openjdk:17-jdk-slim

# Postavi radni direktorijum unutar kontejnera
WORKDIR /app

# Kopiraj generisani JAR fajl iz prethodnog stepa
COPY --from=builder /app/target/backend2-0.0.1-SNAPSHOT.jar backend2.jar

# Izloži port 8080 (ako je Spring Boot aplikacija)
EXPOSE 8080

# Pokreni JAR fajl
CMD ["java", "-jar", "backend2.jar"]