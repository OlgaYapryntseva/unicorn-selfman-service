package com.selfman.business.requests.service;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.selfman.business.requests.dao.BusinessRequestsRepository;
import com.selfman.business.requests.dto.BusinessRequestsCreateDto;
import com.selfman.business.requests.dto.BusinessRequestsDto;
import com.selfman.business.requests.dto.CustomerBusinessRequestsDto;
import com.selfman.business.requests.dto.ProviderBusinessRequestsDto;
import com.selfman.business.requests.exceptions.BusinessRequestsNotFoundException;
import com.selfman.business.requests.model.BusinessRequests;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BusinessRequestsServiceImpl implements BusinessRequestsService{
	
	final ModelMapper modelMapper;
	final BusinessRequestsRepository businessRequestsRepository;

	@Override
	public BusinessRequestsDto createBusinessRequests(BusinessRequestsCreateDto businessRequestsCreateDto) {
		BusinessRequests businessRequests = modelMapper.map(businessRequestsCreateDto, BusinessRequests.class);
        businessRequestsRepository.save(businessRequests);
		return modelMapper.map(businessRequests, BusinessRequestsDto.class);
	}

	@Override
	public BusinessRequestsDto changeStatusRequest(String id, String status) {
		BusinessRequests businessRequests = businessRequestsRepository.findById(id).orElseThrow(BusinessRequestsNotFoundException::new);
		businessRequests.setStatus(status);
		businessRequestsRepository.save(businessRequests);
		return modelMapper.map(businessRequests, BusinessRequestsDto.class);
	}

	@Override
	public  List<CustomerBusinessRequestsDto> getCustomerBusinessRequests(String customerEmail) {
		return businessRequestsRepository.findBusinessRequestsByCustomerEmail(customerEmail).stream()
				.map(b -> modelMapper.map(b, CustomerBusinessRequestsDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<ProviderBusinessRequestsDto> getProviderBusinessRequests(String providerEmail) {
		return businessRequestsRepository.findBusinessRequestsByProviderEmail(providerEmail).stream()
				.map(b -> modelMapper.map(b, ProviderBusinessRequestsDto.class)).collect(Collectors.toList());
	}

	@Override
	public BusinessRequestsDto getByIdBusinessRequests(String id) {
		BusinessRequests businessRequests = businessRequestsRepository.findById(id).orElseThrow(BusinessRequestsNotFoundException::new);
		return modelMapper.map(businessRequests, BusinessRequestsDto.class);
	}

}
