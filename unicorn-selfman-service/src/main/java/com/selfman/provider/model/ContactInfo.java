package com.selfman.provider.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"street", "building"})
public class ContactInfo {
	String country;
	String city;
	String street;
	String building;
	String zipCode;
	String phoneNumber;
	String email;
	String website;
}
