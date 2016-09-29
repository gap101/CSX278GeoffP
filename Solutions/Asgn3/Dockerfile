FROM openjdk:8
MAINTAINER Geoffrey Pettet "geoffrey.a.pettet@vanderbilt.edu"

WORKDIR /app/jhipster-project
ADD build/libs/myapplication-0.0.1-SNAPSHOT.war /app/jhipster-project

EXPOSE 8080

CMD java -jar myapplication-0.0.1-SNAPSHOT.war --spring.profiles.active=dev,swagger