FROM openjdk:11-jdk-alpine
VOLUME /tmp
EXPOSE 5000
ADD build/libs/*.jar proj-mgmt-service.jar
ENV JAVA_OPS=""
ENTRYPOINT ["java", "-jar", "/proj-mgmt-service.jar.jar"]