package io.finloop.haptickt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import co.elastic.apm.attach.ElasticApmAttacher;

@SpringBootApplication
@EnableEurekaServer	// Enable eureka server

public class EurekaServerApp {
	public static void main(String[] args) {
		
		ElasticApmAttacher.attach();
		SpringApplication.run(EurekaServerApp.class, args);
	}

}
