package com.selfman.provider.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProviderDto {
	String email;
    String name;
	String country;
	String logo;
	Set<String> languages;
	Set<String> industry;
	Set<String> keywords;
	Set<String> products;	
	Integer founded;	
	Double rating;	
	Integer reviews;	
	Set<ContactInfoDto> contactInfo;	
	Set<SocialMediaDto> socialMedia;
	
}
