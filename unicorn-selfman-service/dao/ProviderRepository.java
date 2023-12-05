package com.selfman.provider.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.selfman.provider.model.Provider;


public interface ProviderRepository extends MongoRepository<Provider, String> {

}
