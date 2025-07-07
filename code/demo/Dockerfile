# Koristimo official OpenJDK 17 Alpine image (manji, brži)
FROM openjdk:17-jdk-alpine

# Radni direktorijum unutar container-a
WORKDIR /app

# Kopiramo JAR fajl iz lokalnog foldera u container
COPY demo-0.0.1-SNAPSHOT.jar .

# Izlažemo port na kojem aplikacija sluša
EXPOSE 8080

# Komanda za pokretanje aplikacije
CMD ["java", "-jar", "demo-0.0.1-SNAPSHOT.jar"]