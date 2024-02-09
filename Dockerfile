FROM maven:3.9.6-eclipse-temurin-17 as builder
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package

FROM azul/zulu-openjdk-alpine:17-latest
COPY --from=builder /usr/src/app/target/app-exec.jar /usr/app/app-exec.jar
ENV HOSTNAME="Docker"
ENTRYPOINT ["java", "-jar", "/usr/app/app-exec.jar"]
