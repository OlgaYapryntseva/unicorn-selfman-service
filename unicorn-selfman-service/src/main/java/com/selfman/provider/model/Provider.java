package com.selfman.provider.model;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Document(collection = "provider")
public class Provider {	
    @Id
    String providerId;    
    @Indexed(unique = true)
	String email;
    String name;	
	String password;	
    String firstName;   
    String lastName;	
	String logo;	
	Set<String> languages;	
	Set<String> industry;	
	Set<String> keywords;	
	Set<String> products;	
	Integer founded;	
	Double rating;	
	Integer reviews;	
	Set<ContactInfo> contactInfo;	
	Set<SocialMedia> socialMedia;	
	Set<String> roles;	
	
	
	public Provider() {
		languages = new HashSet<String>();
		industry = new HashSet<String>();
		keywords = new HashSet<String>();
		products = new HashSet<String>();
		socialMedia = new HashSet<SocialMedia>();
		contactInfo = new HashSet<ContactInfo>();
		roles = new HashSet<String>();
		rating = 0.0;
		reviews = 0;
		roles.add("PROVIDER");
	}

	public Provider(String email, String password) {
		this();
		this.email = email;
		this.password = password;
	}
	
	
	public void addRole(String role) {
		roles.add(role);
	}
	
	
	public void addIndustry(Set<String> ind) {
		industry.addAll(ind);
	}
	
	public void removeIndustry(String ind) {
		industry.remove(ind);
	}
	
	public void addKeyWord(Set<String> key) {
		keywords.addAll(key);
	}
	
	public void removeKeyWord(String key) {
		keywords.remove(key);
	}
	
	public void addProduct(Set<String> product) {
		products.addAll(product);
	}
	
	public void removeProduct(String product) {
		products.remove(product);
	}
	
	public void addContactInfo(ContactInfo info) {
		contactInfo.add(info);
	}
	
	public void removeContactInfo(ContactInfo info) {
		contactInfo.remove(info);
	}
	
	public void addSocialMedia(SocialMedia media) {
		socialMedia.add(media);
	}
	
	public void removeSocialMedia(SocialMedia media) {
		socialMedia.remove(media);
	}
	
	
	
	
	
	
	
}