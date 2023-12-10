package com.selfman.provider.dto;

import java.util.Set;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProviderRegisterDto {
      String email;
      String password;
      String name;
      String firstName;
      String lastName;
      Set<ContactInfoDto> contactInfo;
}
