# FROM openjdk:17-jdk-alpine
# Use the official OpenJDK 17 image

FROM openjdk:17-jdk-alpine

# Set the maintainer information
MAINTAINER Adrian Enriquez <carlosa.x@gmail.com>

# Define environment variables for MongoDB connection

ENV MONGO_DB=pokemondb
ENV MONGO_USER=usuario_owner
ENV MONGO_PWD=usuario_password
ENV TOMCAT_PORT=8083

# Expose the port on which the application will run

EXPOSE 8083
# Copy the JAR file into the container

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Specify the command to run the application
CMD ["java", "-jar", "/app.jar"]
