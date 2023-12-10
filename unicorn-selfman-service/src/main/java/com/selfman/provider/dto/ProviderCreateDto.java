package com.selfman.provider.dto;

import java.util.Set;
import lombok.Getter;

@Getter
public class ProviderCreateDto {
    String email;
    String name;
    String firstName;
    String lastName;
    Set<ContactInfoDto> contactInfo;
}
