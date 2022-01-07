#
# Build stage
#
# FROM maven:3.8.2-jdk-11-slim AS build
FROM maven:3.8.2-jdk-11-slim

# COPY pom.xml /home/app/pom.xml

# COPY src /home/app/src
# RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
# FROM openjdk:11-jre-slim
# FROM maven:3.8.2-jdk-11-slim
# COPY --from=build /home/app/target/blog-demo-0.0.1-SNAPSHOT.jar /usr/local/lib/blog-demo.jar
EXPOSE 8080
# ENTRYPOINT ["java","-jar","/usr/local/lib/web-demo.jar"]