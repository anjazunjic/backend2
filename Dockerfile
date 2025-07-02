# Koristi zvaničnu sliku sa JDK 17
FROM openjdk:17-jdk-slim

# Postavi radni direktorijum unutar kontejnera
WORKDIR /app

# Kopiraj JAR fajl u kontejner
COPY target/backend2-0.0.1-SNAPSHOT.jar backend2.jar

# Izloži port na kojem aplikacija radi (standardni port za Spring Boot je 8080)
EXPOSE 8080

# Pokreni aplikaciju
CMD ["java", "-jar", "backend2.jar"]