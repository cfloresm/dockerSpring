FROM java:7-jre
MAINTAINER Carlos Flores Martinez
COPY target/demo-0.0.1-SNAPSHOT.jar /usr/src/app/demo-0.0.1-SNAPSHOT.jar
COPY config /usr/src/app/config
WORKDIR /usr/src/app
CMD java -Dspring.config.location=config/application.properties  -jar demo-0.0.1-SNAPSHOT.jar
