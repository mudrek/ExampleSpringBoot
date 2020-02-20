FROM openjdk:13-jdk-slim
COPY target/demo-0.0.1-SNAPSHOT.jar demo.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "demo.jar"]
