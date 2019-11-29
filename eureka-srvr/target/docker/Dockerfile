FROM openjdk:8-jre-alpine
ADD eureka-server.jar /eureka-server.jar
expose 8761
RUN sh -c 'touch /eureka-server.jar'
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=container -jar /eureka-server.jar" ]