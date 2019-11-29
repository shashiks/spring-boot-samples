package io.finloop.haptickt;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import co.elastic.apm.attach.ElasticApmAttacher;

@SpringBootApplication
@EnableEurekaClient	// Enable eureka server
@EnableCircuitBreaker
@EnableHystrix
@EnableHystrixDashboard
//@Configuration
public class ProductClientApp {
	public static void main(String[] args) {
		ElasticApmAttacher.attach();
		SpringApplication.run(ProductClientApp.class, args);
	}
	
	@Configuration
	class RestTemplateConfig {
		
		// Create a bean for restTemplate to call services
		@Bean
		@LoadBalanced		// Load balance between service instances running at different ports.
		public RestTemplate restTemplate() {
			
		    return new RestTemplate();
		}
	}

}
