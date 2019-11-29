package io.finloop.haptickt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import co.elastic.apm.attach.ElasticApmAttacher;

@SpringBootApplication
@EnableEurekaClient 		// It acts as a eureka client
@EnableZuulProxy		// Enable Zuul

public class SpringZuulApp {
	public static void main(String[] args) {
		ElasticApmAttacher.attach();
		SpringApplication.run(SpringZuulApp.class, args);
	}
	
	@Bean
	public AuthHeaderFilter getAuthenticatedFilter () {
	    return new AuthHeaderFilter();
	}
}
