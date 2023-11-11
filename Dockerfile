# FROM openjdk:17-jdk-alpine
FROM openjdk:17-oracle
MAINTAINER Adrian Enriquez <carlosa.x@gmail.com>

# Define environment variables for MongoDB connection
ENV MONGO_DB pokemondb
ENV MONGO_USER usuario_owner
ENV MONGO_PWD usuario_password
ENV TOMCAT_PORT 8083
EXPOSE 8083

ARG JAR_FILE=target/*.jar
COPY target/*.jar app.jar
CMD ["java", "-jar", "/app.jar"]
