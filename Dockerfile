# syntax=docker/dockerfile:1

#-------------------------- Stage 1/2: build

FROM maven:3-eclipse-temurin-11 AS builder
WORKDIR /app
COPY pom.xml ./
# build all dependencies for offline use, dependencies will be stored in docker cache
RUN mvn dependency:go-offline -B -DskipTests

COPY src ./src
RUN mvn clean package

#-------------------------- Stage 2/2: deploy

FROM eclipse-temurin:11-jdk-focal
WORKDIR /app
COPY --from=builder /app/target/*.jar ./*.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/*.jar"]