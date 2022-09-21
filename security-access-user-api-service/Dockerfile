FROM adoptopenjdk/openjdk11:alpine-jre

VOLUME /tmp
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} security-access-module-api-service-2.0.0.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=dev","security-access-module-api-service-2.0.0.jar"]