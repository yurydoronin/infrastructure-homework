FROM bellsoft/liberica-openjre-alpine:11
EXPOSE 8080
ARG JAR_FILE=build/libs/*-1.0.0.jar
COPY ${JAR_FILE} people.jar
ENTRYPOINT ["java","-jar","/people.jar"]