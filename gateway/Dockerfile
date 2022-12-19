FROM eclipse-temurin:11.0.17_8-jdk
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} gateway.jar
ENTRYPOINT ["java","-jar","/gateway.jar"]