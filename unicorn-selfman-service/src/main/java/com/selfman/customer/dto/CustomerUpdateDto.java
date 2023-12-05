package com.selfman.customer.dto;

import lombok.Getter;

@Getter
public class CustomerUpdateDto {
	String firstName;
	String lastName;
	String country;
	String city;
	String street;
	String building;
	String zipcode;
	String phoneNumber;

}
