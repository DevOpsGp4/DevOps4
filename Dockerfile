FROM openjdk:latest
COPY ./target/DevOps-0.1.0.1-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "DevOps-0.1.0.1-jar-with-dependencies.jar"]