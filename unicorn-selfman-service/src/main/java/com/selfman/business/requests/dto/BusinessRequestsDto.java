package com.selfman.business.requests.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.selfman.customer.dto.CustomerDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BusinessRequestsDto {
	String id;
	String productDescription;
	List<String> files;
	String status;
	CustomerDto customer;
	ProviderDto provider;
	LocalDateTime dateTime;
	
}
