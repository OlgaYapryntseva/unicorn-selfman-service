package com.selfman.business.requests.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.selfman.business.requests.dto.BusinessRequestsCreateDto;
import com.selfman.business.requests.dto.BusinessRequestsDto;
import com.selfman.business.requests.dto.CustomerBusinessRequestsDto;
import com.selfman.business.requests.dto.ProviderBusinessRequestsDto;
import com.selfman.business.requests.service.BusinessRequestsService;
import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
public class BusinessRequestsController{
	
	final BusinessRequestsService businessRequestsService;
	
	@PostMapping("/business")
	public BusinessRequestsDto createBusinessRequests(@RequestBody BusinessRequestsCreateDto businessRequestsCreateDto) {
		System.out.println("createBusinessRequests");
		return businessRequestsService.createBusinessRequests(businessRequestsCreateDto);
	}

	@PutMapping("/business/{id}/{status}")
	public BusinessRequestsDto changeStatusRequest(@PathVariable String id,@PathVariable String status) {
		return businessRequestsService.changeStatusRequest(id, status);
	}

	@GetMapping("/business/customer/{customerEmail}")
	public List<CustomerBusinessRequestsDto> getCustomerBusinessRequests(@PathVariable String customerEmail) {
		return businessRequestsService.getCustomerBusinessRequests(customerEmail);
	}

	@GetMapping("/business/provider/{providerEmail}")
	public List<ProviderBusinessRequestsDto> getProviderBusinessRequests(@PathVariable String providerEmail) {
		return businessRequestsService.getProviderBusinessRequests(providerEmail);
	}

	@GetMapping("/business/{id}")
	public BusinessRequestsDto getByIdBusinessRequests(@PathVariable String id) {
		return businessRequestsService.getByIdBusinessRequests(id);
	}

}
