package com.selfman.business.requests.dto;

import java.util.List;

import lombok.Getter;

@Getter
public class BusinessRequestsCreateDto {
	String providerEmail;
	String customerEmail;
	String productDescription;
	List<String> files;
	
}
