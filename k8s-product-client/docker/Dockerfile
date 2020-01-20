FROM openjdk:8-jre-alpine
VOLUME /tmp
expose 8300 3306
ADD product-k8-0.0.1-SNAPSHOT.jar /product-service.jar
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=container -jar /product-service.jar" ]