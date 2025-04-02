FROM maven:3.9.4-eclipse-temurin-21-alpine AS build
WORKDIR /app
COPY --chown=maven:maven . /app
RUN mvn clean package -DskipTests

FROM bellsoft/liberica-openjdk-alpine:21 AS builder
WORKDIR /app
COPY --from=build /app/target/config-server-0.0.1-SNAPSHOT.jar /app/config-server.jar
RUN java -Djarmode=layertools -jar config-server.jar extract

FROM bellsoft/liberica-openjdk-alpine:21
WORKDIR /app
COPY --from=builder app/dependencies/ ./
COPY --from=builder app/spring-boot-loader/ ./
COPY --from=builder app/snapshot-dependencies/ ./
COPY --from=builder app/application/ ./
ENTRYPOINT ["java", "org.springframework.boot.loader.launch.JarLauncher"]
