FROM maven:3.5-jdk-11 AS build
COPY pom.xml ./
COPY src ./src/
RUN mvn clean package

FROM openjdk:13-jdk-slim
COPY --from=build target/demo-0.0.1-SNAPSHOT.jar demo.jar
COPY target/demo-0.0.1-SNAPSHOT.jar demo.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "demo.jar"]
