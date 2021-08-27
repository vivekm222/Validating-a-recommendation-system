FROM maven:latest AS base

RUN mkdir -p /code
WORKDIR /code

COPY ./src ./src
COPY ./pom.xml ./pom.xml

RUN mvn clean && mvn package

ENTRYPOINT ["java", "-cp", "./target/GPA-Calculator-1.0-jar-with-dependencies.jar", "RestfulServer"]