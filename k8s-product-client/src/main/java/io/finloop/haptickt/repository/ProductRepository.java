package io.finloop.haptickt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.finloop.haptickt.entities.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long>{
	
	
//	List<Product> getProductsByIdInAndNameLike()

}
