package com.selfman.business.requests.dao;

import java.util.List;


import org.springframework.data.mongodb.repository.MongoRepository;
import com.selfman.business.requests.model.BusinessRequests;

public interface BusinessRequestsRepository extends MongoRepository<BusinessRequests, String>{

	List<BusinessRequests> findBusinessRequestsByCustomerEmail(String customerEmail);

    List<BusinessRequests> findBusinessRequestsByProviderEmail(String providerEmail);


}
