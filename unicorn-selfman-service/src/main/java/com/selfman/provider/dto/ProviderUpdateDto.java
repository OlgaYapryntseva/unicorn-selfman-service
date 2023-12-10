package com.selfman.provider.dto;

import java.util.Set;
import lombok.Getter;

@Getter
public class ProviderUpdateDto {

	String logo;
	String name;
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
