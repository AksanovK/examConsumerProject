FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/application/src
COPY pom.xml /home/application
USER root
RUN --mount=type=cache,target=/.m2 mvn -f /home/application/pom.xml clean package

FROM openjdk:11-jre-slim
COPY --from=build /home/application/target/consumer.jar /usr/local/lib/consumer.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/usr/local/lib/consumer.jar"]
