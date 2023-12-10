package com.selfman.customer.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.selfman.customer.model.Customer;


public interface CustomerRepository extends MongoRepository<Customer, String>{
	
	 Optional<Customer> findByEmail(String email);
	 
	 boolean existsByEmail(String email);

}
