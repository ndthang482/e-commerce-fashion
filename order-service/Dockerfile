FROM eclipse-temurin:11.0.17_8-jdk
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} order-service.jar
ENTRYPOINT ["java","-jar","/order-service.jar"]