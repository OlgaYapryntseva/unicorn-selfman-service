package com.selfman.business.requests.dto;

import java.time.LocalDateTime;
import java.util.List;

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
	String providerEmail;
	String customerEmail;
	String productDescription;
	String status;
	List<String> files;
	LocalDateTime dateTime;
	
}
