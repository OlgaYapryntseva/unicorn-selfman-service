package com.selfman.provider.controller;

import java.security.Principal;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.selfman.provider.dto.ProviderCreateDto;
import com.selfman.provider.dto.ProviderDto;
import com.selfman.provider.dto.ProviderRegisterDto;
import com.selfman.provider.dto.ProviderRemoveDto;
import com.selfman.provider.dto.ProviderUpdateDto;
import com.selfman.provider.service.ProviderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ProviderController{
	
	final ProviderService providerService;

	@PostMapping("/provider/register")
	public ProviderCreateDto createProvider(@RequestBody ProviderRegisterDto providerRegisterDto) {
		return providerService.createProvider(providerRegisterDto);
	}
	
	@PostMapping("/provider/login")
	public ProviderDto login(Principal principal) {
		return getProvider(principal.getName());
	}

	@PutMapping("/provider/{email}")
	public ProviderUpdateDto updateProvider(Principal principal, @RequestBody ProviderUpdateDto providerUpdateDto) {
		return providerService.updateProvider(principal.getName(), providerUpdateDto);
	}

	@DeleteMapping("/provider/{email}")
	public ProviderRemoveDto removeProvider(@PathVariable String email) {
		return providerService.removeProvider(email);
	}

	@PutMapping("/provider/password")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void changePasswordProvider(Principal principal, @RequestHeader("X-Password") String newPassword) {
		providerService.changePasswordProvider(principal.getName(), newPassword);
	}

	@GetMapping("/provider/name/{email}")
	public ProviderDto getProvider(@PathVariable String email) {
		return providerService.getProvider(email);
	}
	

}
