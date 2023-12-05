package com.selfman.provider.dto;

import java.util.Set;

import com.selfman.provider.model.ContactInfo;
import com.selfman.provider.model.SocialMedia;

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
    Set<ContactInfo> contactInfo;	
	Set<SocialMedia> socialMedia;
	
}
