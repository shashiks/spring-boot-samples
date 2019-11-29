FROM openjdk:8-jre-alpine
ADD product-service.jar /product-service.jar
expose 8200
RUN sh -c 'touch /product-service.jar'
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=container -jar /product-service.jar" ]