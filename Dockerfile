FROM openjdk:8-jdk-alpine
ENTRYPOINT ["java","-jar","/target/springmvc-0.0.1.jar"]
CMD ["-jar","//target/springmvc-0.0.1.jar"]