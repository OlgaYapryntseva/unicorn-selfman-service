package com.selfman.provider.products.dao;


import org.springframework.data.mongodb.repository.MongoRepository;
import com.selfman.provider.products.model.Products;



public interface ProductsRepositoty extends MongoRepository<Products, String>{


}
