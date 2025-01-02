FROM openjdk:17-jdk-alpine
COPY./target/springdemo-0.0.1-SNAPSHOT.jar springboot.jar
LABEL authors="arun"

ENTRYPOINT ["java","-jar","/springboot.jar"]