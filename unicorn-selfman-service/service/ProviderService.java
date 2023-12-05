package com.selfman.provider.service;

import com.selfman.provider.dto.ProviderChangePasswordDto;
import com.selfman.provider.dto.ProviderCreateDto;
import com.selfman.provider.dto.ProviderDto;
import com.selfman.provider.dto.ProviderRegisterDto;
import com.selfman.provider.dto.ProviderRemoveDto;

public interface ProviderService {
   ProviderCreateDto createProvider(ProviderRegisterDto providerRegisterDto);
   
   ProviderDto updateProvider(String email, ProviderDto providerDto);
   
   ProviderRemoveDto removeProvider(String email);
   
   ProviderChangePasswordDto changePasswordProvider(ProviderChangePasswordDto providerChangePasswordDto);
   
   ProviderDto getProvider(String email);

   

   
}
