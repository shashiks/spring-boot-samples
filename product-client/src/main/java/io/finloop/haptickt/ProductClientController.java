package io.finloop.haptickt;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


//@Slf4j
@RestController
@RequestMapping("/")
public class ProductClientController {

	
	@Autowired
//    @LoadBalanced
    private RestTemplate restTemplate;
	
	@Autowired
	private Environment env;
	
	static final String productUrl =  "http://service-product-svc:8300/products/"; //"http://product-service/products/";
	
	
	@RequestMapping("/")
	public String home() {
		return "Home from product-client running at port: " + env.getProperty("local.server.port");
	}
  
	
//	@HystrixCommand(
//			fallbackMethod = "getDefaultProductCommand",
//			groupKey = "GetProducts", commandKey = "GetProducts", threadPoolKey = "GetProducts", 
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/product/{id}")
	public List<ProductValue> getProducts(@PathVariable final int id) {

//		log.info("replying from Client");
		Object resp = restTemplate.getForEntity(productUrl, Object.class);
//		log.info("Got response " + resp);
		ResponseEntity resEntity = (ResponseEntity) resp;
//		log.info("Resp entity " + resEntity);
		List<ProductValue> products = (List<ProductValue>) resEntity.getBody();
//		log.info("products " + products);
		return products;
		
//		Can also use below syntax to get records directly without response body
////		if(resEntity.getStatusCode().equals(HttpStatus.OK)) {
////			@SuppressWarnings("unchecked")
////		} else {
////			return null;
////		}

//		log.info("replying from Client");
//		Object resp = restTemplate.getForObject("http://product-service/products/", Object.class);
//		log.info("resp" + resp);
//		List<ProductValue> products = (List<ProductValue>) resp;
//		return products;
	}
	
//	
//	List<ProductValue> getDefaultProductCommand(int productCode) {
//		List<ProductValue> l = new ArrayList<>();
//		l.add(ProductValue.builder().id(4L).name("FallBack").description("Static fallback product").build());
//		l.add(ProductValue.builder().id(1L).name("Info Prod").description("from " + env.getProperty("local.server.port")).build());
//		l.add(ProductValue.builder().id(2L).name("First Prod").description("First Description").build());
//		l.add(ProductValue.builder().id(3L).name("Second Prod").description("Second Description").build());
//		return l;
//    }
	
	
	
	@RequestMapping("/admin")
	public String homeAdmin() {
		return "Client service running at port: " + env.getProperty("local.server.port");
	}
}