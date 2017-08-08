FROM openjdk:8-jdk

USER root
ARG jarFile=springboot-1.0-SNAPSHOT.jar
ARG http_port=8081
COPY ${jarFile} /projects/

EXPOSE ${http_port}
ENTRYPOINT ["java", "-jar", "/projects/springboot-1.0-SNAPSHOT.jar", "&"]