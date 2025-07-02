# Koristi Maven sliku sa JDK 17
FROM maven:3.8.4-openjdk-17-slim AS builder

# Postavi radni direktorijum unutar kontejnera
WORKDIR /app

# Kopiraj Maven fajl (pom.xml) i sve ostale fajlove u direktorijum
COPY pom.xml .

# Preuzmi zavisnosti (ovo je cache-ovano za brže buildove)
RUN mvn dependency:go-offline

# Kopiraj sav kod iz lokalnog direktorijuma u kontejner
COPY src /app/src

# Izgradnja aplikacije i generisanje JAR fajla
RUN mvn clean package -DskipTests

# Drugi korak: Pokreni JAR fajl sa OpenJDK 17
FROM openjdk:17-jdk-slim

# Postavi radni direktorijum unutar kontejnera
WORKDIR /app

# Kopiraj generisani JAR fajl iz prethodnog stepa
COPY --from=builder /app/target/backend2-0.0.1-SNAPSHOT.jar backend2.jar

# Izloži port 8080
EXPOSE 8080

# Pokreni aplikaciju
CMD ["java", "-jar", "backend2.jar"]