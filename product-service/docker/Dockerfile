FROM adoptopenjdk:11-jre-hotspot
ADD product-service.jar /product-service.jar
expose 8200 3306
RUN sh -c 'touch /product-service.jar'
ENTRYPOINT [ "sh", "-c", "java -XX:+UseContainerSupport $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=container -jar /product-service.jar" ]
