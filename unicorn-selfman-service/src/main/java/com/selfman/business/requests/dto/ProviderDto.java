package com.selfman.business.requests.dto;

import java.util.Set;

import lombok.Getter;

@Getter
public class ProviderDto {
	String id;
	String name;
	String email;
	String country;
	Set<String> industry;
	Set<String> keywords;
	String website;
	String phoneNumber;
	Integer rating;
	Double reviews;

}
