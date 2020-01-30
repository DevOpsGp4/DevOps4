FROM openjdk:latest

COPY ./target/DevOps4-0.1.0.1-jar-with-dependencies.jar /tmp
# Copy DevOps4-0.1.0.1-jar-with-dependencies.jar
# This is specific to Application Startup.

WORKDIR /tmp
# Copy all the files to the working directory of the container

ENTRYPOINT ["java", "-jar", "DevOps4-0.1.0.1-jar-with-dependencies.jar", "db:3306"]
    #Main dockerfile which to run application over dependencies package from maven
