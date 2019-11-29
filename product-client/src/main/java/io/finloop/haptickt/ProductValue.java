	package io.finloop.haptickt;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Builder;
import lombok.Getter;
//import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class ProductValue {
		
	@Getter private Long id;
	
	@Getter private String name;
	
	@Getter private String description;
	

}
