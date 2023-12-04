package com.selfman.business.requests.model;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "businessrequests")
public class BusinessRequests {
	@Id
	String id;
	String productDescription;
	List<String> files;
	String status;
	Customer customer;
	Provider provider;
	LocalDateTime dateTime = LocalDateTime.now();
	String providerEmail;
    String customerEmail;
	
}

//String id = new java.math.BigInteger(336,new Random()).toString().substring(0,10);