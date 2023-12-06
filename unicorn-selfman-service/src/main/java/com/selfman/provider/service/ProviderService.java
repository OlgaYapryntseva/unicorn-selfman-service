package com.selfman.provider.service;

import com.selfman.provider.dto.ProviderCreateDto;
import com.selfman.provider.dto.ProviderDto;
import com.selfman.provider.dto.ProviderRegisterDto;
import com.selfman.provider.dto.ProviderRemoveDto;
import com.selfman.provider.dto.ProviderUpdateDto;

public interface ProviderService {
   ProviderCreateDto createProvider(ProviderRegisterDto providerRegisterDto);
   
   ProviderDto updateProvider(String email, ProviderUpdateDto providerUpdateDto);
   
   ProviderRemoveDto removeProvider(String email);
   
   void changePasswordProvider(String email, String newPassword);
   
   ProviderDto getProvider(String email);
   

  
}
