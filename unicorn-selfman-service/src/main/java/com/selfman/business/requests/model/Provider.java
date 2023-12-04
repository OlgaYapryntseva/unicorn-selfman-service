package com.selfman.business.requests.model;

import java.time.LocalDateTime;
import java.util.Set;
import lombok.Getter;


@Getter
public class Provider {
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
     LocalDateTime dateTime;
}
