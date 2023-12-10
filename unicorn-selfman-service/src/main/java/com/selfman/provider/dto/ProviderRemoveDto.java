package com.selfman.provider.dto;

import org.springframework.data.mongodb.core.index.Indexed;

import lombok.Getter;

@Getter
public class ProviderRemoveDto {
   String name;
   @Indexed(unique = true)
   String email;
}
