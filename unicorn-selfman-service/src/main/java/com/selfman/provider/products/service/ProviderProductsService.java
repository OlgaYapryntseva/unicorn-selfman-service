package com.selfman.provider.products.service;

import com.selfman.provider.products.dto.ProductsDto;

public interface ProviderProductsService {
  
	ProductsDto addProduct(String email, ProductsDto productsDto);
	
	ProductsDto updateProduct(String email, String productId, ProductsDto productsDto);
	
	ProductsDto removeProduct(String email, String productId);
	
	ProductsDto getProduct(String productId);
	
}
