FROM maven:3.8-openjdk-11-slim as builder
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package

FROM ibmjava:11
COPY --from=builder /usr/src/app/target/app-exec.jar /usr/app/app-exec.jar
ENV HOSTNAME="Docker"
ENTRYPOINT ["java", "-jar", "/usr/app/app-exec.jar"]