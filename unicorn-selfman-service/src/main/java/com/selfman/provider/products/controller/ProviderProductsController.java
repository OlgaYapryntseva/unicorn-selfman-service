package com.selfman.provider.products.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.selfman.provider.products.dto.ProductsDto;
import com.selfman.provider.products.service.ProviderProductsService;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
public class ProviderProductsController {
	
	final ProviderProductsService providerProductsService;

	@PostMapping("/provider/{email}/items")
	public ProductsDto addProduct(@PathVariable String email,@RequestBody ProductsDto productsDto) {
		return providerProductsService.addProduct(email, productsDto);
	}
	

	@PutMapping("/provider/{email}/item/{productId}")
	public ProductsDto updateProvider(@PathVariable String email, @PathVariable String productId, @RequestBody ProductsDto productsDto) {
		return providerProductsService.updateProduct(email, productId, productsDto);
	}

	@DeleteMapping("/provider/{email}/item/{productId}")
	public ProductsDto removeProvider(@PathVariable String email, @PathVariable String productId) {
		return providerProductsService.removeProduct(email, productId);
	}

	@GetMapping("/provider/items/{productId}")
	public ProductsDto getProvider(@PathVariable String productId) {
		return providerProductsService.getProduct(productId);
	}
}
