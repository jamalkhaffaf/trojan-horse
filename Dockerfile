FROM openjdk:17-jdk-alpine
COPY ./target/trojan-horse*.jar app.jar
ENTRYPOINT [ "java", "-jar", "/app.jar" ]
