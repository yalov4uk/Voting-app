FROM openjdk:8-jdk-alpine

WORKDIR /app

VOLUME /tmp

ADD core/target/VotingApp.jar app.jar

ENV JAVA_OPTS=""

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar app.jar" ]
