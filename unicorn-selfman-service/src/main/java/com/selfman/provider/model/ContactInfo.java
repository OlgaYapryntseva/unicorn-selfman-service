package com.selfman.provider.model;

import java.util.Random;
import org.springframework.data.annotation.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactInfo {
	     @Id
	     Integer contactInfoId = (int) new Random().nextInt(200000);
         String country;
         String city;
         String street;
         String building;
         String zipCode;
         String phoneNumber;
         String email;
         String website;
         
     
         
}
