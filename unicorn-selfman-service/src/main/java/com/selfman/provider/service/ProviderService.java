package com.selfman.provider.service;

import com.selfman.provider.dto.ProviderChangePasswordDto;
import com.selfman.provider.dto.ProviderCreateDto;
import com.selfman.provider.dto.ProviderDto;
import com.selfman.provider.dto.ProviderRegisterDto;
import com.selfman.provider.dto.ProviderRemoveDto;
import com.selfman.provider.dto.ProviderUpdateDto;

public interface ProviderService {
   ProviderCreateDto createProvider(ProviderRegisterDto providerRegisterDto);
   
   ProviderUpdateDto updateProvider(String email, ProviderUpdateDto providerDto);
   
   ProviderRemoveDto removeProvider(String email);
   
   void changePasswordProvider(ProviderChangePasswordDto providerChangePasswordDto);
   
   ProviderDto getProvider(String email);
   

  
}
