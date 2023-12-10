package com.selfman.provider.dto;

import java.util.Set;

import lombok.Getter;

@Getter
public class ProviderRegisterDto {
	String email;
	String password;
	String name;
	String firstName;
	String lastName;
	Set<ContactInfoDto> contactInfo;
}
