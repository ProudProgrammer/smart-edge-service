FROM openjdk:11
COPY release/target/edge-service-release-1.0-SNAPSHOT.jar edge-service.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/edge-service.jar"]