FROM openjdk:8-jre-alpine
ADD product-service-client-0.0.1-SNAPSHOT.jar /product-service-client.jar
expose 8100 8300
VOLUME /tmp
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=container -jar /product-service-client.jar" ]
