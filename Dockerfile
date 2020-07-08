FROM openjdk:8-jdk-alpine
EXPOSE 8080
COPY target/springmvc-0.0.1.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
CMD ["-jar","/app.jar"]