package com.selfman.business.requests.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {
    String id;
    String firstName;
    String lastName;
    String email;
    String city;
    String phoneNumber;
}
