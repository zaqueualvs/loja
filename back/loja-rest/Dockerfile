FROM amazoncorretto:21-alpine-jdk
RUN mkdir /app
WORKDIR /app
COPY target/*.jar /app/app.jar
CMD ["java", "-jar", "/app/app.jar"]