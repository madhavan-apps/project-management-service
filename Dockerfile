FROM openjdk:12-jdk-alpine
VOLUME /tmp
EXPOSE 5000
ADD project-management-service-0.0.1-SNAPSHOT.jar proj-mgmt-service.jar
ENV JAVA_OPS=""
ENTRYPOINT ["java", "-jar", "/proj-mgmt-service.jar"]