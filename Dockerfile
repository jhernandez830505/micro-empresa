FROM openjdk:13-alpine


ENV TZ=America/Mexico_City
RUN apk add --no-cache tzdata
RUN apk update && apk add /bin/sh

RUN mkdir -p /opt/app

ARG JAR_FILE=target/micro-empresa-0.0.1.jar

ADD ${JAR_FILE} app.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]