package com.selfman.customer.dto;

import lombok.Getter;

@Getter
public class CustomerRegisterDto {
	String firstName;
    String lastName;
    String email;
    String country;
    String password;
}
