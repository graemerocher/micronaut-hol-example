FROM openjdk:14-alpine
COPY build/libs/example-atp-*-all.jar example-atp.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "example-atp.jar"]