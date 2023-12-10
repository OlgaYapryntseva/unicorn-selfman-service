package com.selfman.provider.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(of = {"street", "building"})
public class ContactInfo {
//	@Id
//	Integer contactInfoId = (int) new Random().nextInt(200000);
	String country;
	String city;
	String street;
	String building;
	String zipCode;
	String phoneNumber;
	String email;
	String website;

}
