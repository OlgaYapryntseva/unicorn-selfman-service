package com.selfman.business.requests.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Document(collection = "businessrequests")
public class BusinessRequests {
	@Id
	String id;
	String providerEmail;
	String customerEmail;
	String productDescription;
	String status;
	List<String> files;
	LocalDateTime dateTime = LocalDateTime.now();
	
	public BusinessRequests() {
		status = "New";
	}
	
}