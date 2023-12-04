package com.selfman.business.requests.dto;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;



@Getter
public class BusinessRequestsDto {
	String id;
	String productDescription;
	List<String> files;
	String status;
	CustomerDto customer;
	ProviderDto provider;
	LocalDateTime dateTime;
}
