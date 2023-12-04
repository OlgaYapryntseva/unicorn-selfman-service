package com.selfman.provider.dto;

import lombok.Getter;

@Getter
public class ProviderChangePasswordDto {
    String email;
    String newPassword;
}
