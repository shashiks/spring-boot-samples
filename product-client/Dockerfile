FROM adoptopenjdk:11-jre-hotspot
ADD target/product-service-client-0.0.1-SNAPSHOT.jar /product-client.jar
expose 8100 8300
VOLUME /tmp
ENTRYPOINT [ "sh", "-c", "java -XX:+UseContainerSupport $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=container -jar /product-client.jar" ]
