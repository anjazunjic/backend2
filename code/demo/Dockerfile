FROM maven:3.8.6-openjdk-17 AS build
WORKDIR /app
COPY code/demo/pom.xml .
COPY code/demo/src ./src
RUN mvn clean package

FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/demo-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
CMD ["java", "-jar", "demo-0.0.1-SNAPSHOT.jar"]