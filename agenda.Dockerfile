FROM openjdk:17
COPY target/agenda-0.0.1-SNAPSHOT.jar /agendasapp2.jar
CMD ["java", "-jar", "/agendasapp2.jar"]