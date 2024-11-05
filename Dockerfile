FROM openjdk:8-jdk-slim

RUN apt-get update && apt-get install -y curl && rm -rf /var/lib/apt/lists/*

RUN curl -o app.jar -u admin:admin "http://192.168.33.10:8081/repository/maven-releases/tn/esprit/spring/gestion-station-ski/1.2/gestion-station-ski-1.2.jar"

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]