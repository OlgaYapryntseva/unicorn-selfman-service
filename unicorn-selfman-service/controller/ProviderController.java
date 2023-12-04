package com.selfman.provider.controller;

import java.security.Principal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.selfman.provider.dto.ProviderChangePasswordDto;
import com.selfman.provider.dto.ProviderCreateDto;
import com.selfman.provider.dto.ProviderDto;
import com.selfman.provider.dto.ProviderRegisterDto;
import com.selfman.provider.dto.ProviderRemoveDto;
import com.selfman.provider.service.ProviderService;
import lombok.RequiredArgsConstructor;



@RestController
@RequiredArgsConstructor
public class ProviderController{
	
	final ProviderService providerService;

	@PostMapping("/provider")
	public ProviderCreateDto createProvider(@RequestBody ProviderRegisterDto providerRegisterDto) {
		return providerService.createProvider(providerRegisterDto);
	}

	
	@PostMapping("/provider/login")
	public boolean login(Principal principal) {
		return !principal.getName().isEmpty();
	}
	
	@PutMapping("/provider/{email}")
	public ProviderDto updateProvider(@PathVariable String email, @RequestBody ProviderDto providerDto) {
		return providerService.updateProvider(email, providerDto);
	}

	@DeleteMapping("/provider/{email}")
	public ProviderRemoveDto removeProvider(@PathVariable String email) {
		return providerService.removeProvider(email);
	}

	@PutMapping("/provider/password")
	public ProviderChangePasswordDto changePasswordProvider(@RequestBody ProviderChangePasswordDto providerChangePasswordDto) {
		return providerService.changePasswordProvider(providerChangePasswordDto);
	}

	@GetMapping("/provider/name/{email}")
	public ProviderDto getProvider(@PathVariable String email) {
		return providerService.getProvider(email);
	}
	

}
