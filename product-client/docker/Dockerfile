FROM openjdk:8-jre-alpine
ADD product-service-client.jar /product-service-client.jar
expose 8100
RUN sh -c 'touch /product-service-client.jar'
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=container -jar /product-service-client.jar" ]