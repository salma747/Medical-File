FROM adoptopenjdk/openjdk11:latest
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} medical-file-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/medical-file-1.0-SNAPSHOT.jar"]