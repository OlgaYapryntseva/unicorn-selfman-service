package com.selfman.business.requests.service;

import java.util.List;
import com.selfman.business.requests.dto.BusinessRequestsCreateDto;
import com.selfman.business.requests.dto.BusinessRequestsDto;
import com.selfman.business.requests.dto.CustomerBusinessRequestsDto;
import com.selfman.business.requests.dto.ProviderBusinessRequestsDto;

public interface BusinessRequestsService {
	
     BusinessRequestsDto createBusinessRequests (BusinessRequestsCreateDto businessRequestsCreateDto);
     
     BusinessRequestsDto changeStatusRequest(String id, String status);
     
     List<CustomerBusinessRequestsDto> getCustomerBusinessRequests (String customerEmail);
     
     List<ProviderBusinessRequestsDto> getProviderBusinessRequests (String providerEmail);
     
     BusinessRequestsDto getByIdBusinessRequests (String id, String email);
}
