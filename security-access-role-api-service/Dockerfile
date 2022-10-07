FROM adoptopenjdk/openjdk11:alpine-jre

VOLUME /tmp
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} security-access-role-api-service-2.0.1.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=dev","security-access-role-api-service-2.0.1.jar"]