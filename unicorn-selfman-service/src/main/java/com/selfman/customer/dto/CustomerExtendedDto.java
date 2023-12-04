package com.selfman.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerExtendedDto {
	String firstName;
    String lastName;
    String email;
    String country;
    String city;
    String street;
	String building;
	String zipcode;
    String phoneNumber;

}
