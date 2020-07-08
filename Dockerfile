FROM openjdk:8-jdk-alpine
EXPOSE 8080
COPY target/springmvc-0.0.1.jar app.jar
COPY keystore.p12 keystore.p12
ENTRYPOINT ["java","-jar","/app.jar"]
CMD ["-jar","/app.jar"]