package com.selfman.provider.products.dao;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.selfman.provider.products.model.Products;



public interface ProductsRepositoty extends MongoRepository<Products, String>{

	
	@Query("{name: ?0, providerEmail: ?1}")
	List<Products> findByNameIgnoreCaseAndProviderEmail(String name, String email);
	


}
