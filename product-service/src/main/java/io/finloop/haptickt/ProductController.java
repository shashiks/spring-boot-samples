package io.finloop.haptickt;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.finloop.haptickt.entities.ProductEntity;
import io.finloop.haptickt.repository.ProductRepository;
//import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/")
//@EnableAutoConfiguration
//@Slf4j
public class ProductController {
	
	
	@Autowired
	private Environment env;
	
	@Autowired
	private ProductRepository productRepo;
		
//	@HystrixCommand(
//			fallbackMethod = "getCacheDBProductDataCommand",
//			groupKey = "listProducts", commandKey = "listProducts", threadPoolKey = "listProducts", 
//			commandProperties = {
//				@HystrixProperty(name = "execution.isolation.strategy", value = "THREAD"),
//		        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "30000"),
//		        @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "4"),
//		        @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "60000"),
//		        @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "180000") 
//		    }, 
//			threadPoolProperties = {
//		        @HystrixProperty(name = "coreSize", value = "30"),
//		        @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "180000") 
//		     }
//	)		
	@GetMapping(path = "/products",  produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<ProductEntity> getProducts() {
		System.out.println("Sakffold Logs added");
		List<ProductEntity> products = productRepo.findAll();
		ProductEntity p = new ProductEntity();
		p.setId(100L);
		p.setName("Debug Product");
		p.setDescription("From Port " + env.getProperty("server.port"));
		products.add(p);
//		products.add(ProductEntity.builder().id(100l).name("Info Product").description("From Port " + env.getProperty("server.port")).build());
//		log.info("sending data from service" + products);
		System.out.println("sending resp product-svc -- " + System.currentTimeMillis());
		return products;
	}
	
	
//	@SuppressWarnings("unused")
//	private List<ProductEntity> getCacheDBProductDataCommand() {
//		List<ProductEntity> l = new ArrayList<>();
//		l.add(ProductEntity.builder().id(4L).name("FallBack From Product Service").description("Static fallback product").build());
//		l.add(ProductEntity.builder().id(1L).name("Info Prod").description("from " + env.getProperty("local.server.port")).build());
//		l.add(ProductEntity.builder().id(2L).name("First Prod").description("First Description").build());
//		l.add(ProductEntity.builder().id(3L).name("Second Prod").description("Second Description").build());
//		return l;
//	}
//	
	
	
	
}