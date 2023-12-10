package com.selfman.provider.dao;


import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.selfman.provider.model.Provider;


public interface ProviderRepository extends MongoRepository<Provider, String> {
	
	boolean existsByEmail(String email);

	Optional<Provider> findByEmail(String email);


}
