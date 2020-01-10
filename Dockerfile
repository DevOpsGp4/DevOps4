FROM openjdk:latest
COPY ./target/DevOps4-0.1.0.1-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "DevOps4-0.1.0.1-jar-with-dependencies.jar"]