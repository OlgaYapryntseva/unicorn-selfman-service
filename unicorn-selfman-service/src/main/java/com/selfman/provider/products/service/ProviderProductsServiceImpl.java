package com.selfman.provider.products.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.selfman.provider.products.dao.ProductsRepositoty;
import com.selfman.provider.products.dto.ProductsDto;
import com.selfman.provider.products.exceptions.ProductNotFoundException;
import com.selfman.provider.products.model.Products;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProviderProductsServiceImpl implements ProviderProductsService {

	final ProductsRepositoty productsRepositoty;
	final ModelMapper modelMapper;

	@Override
	public ProductsDto addProduct(String email, ProductsDto productsDto) {
		Products product = modelMapper.map(productsDto, Products.class);
		product.setProviderEmail(email);
		productsRepositoty.save(product);
		return modelMapper.map(product, ProductsDto.class);
	}

	@Override
	public ProductsDto updateProduct(String email, String productId, ProductsDto productsDto) {
		Products product = productsRepositoty.findById(productId).orElseThrow(ProductNotFoundException::new);
		modelMapper.getConfiguration().setSkipNullEnabled(true);
		modelMapper.map(productsDto, product);
		productsRepositoty.save(product);
		return modelMapper.map(product, ProductsDto.class);
	}

	@Override
	public ProductsDto removeProduct(String email, String productId) {
		Products product = productsRepositoty.findById(productId).orElseThrow(ProductNotFoundException::new);
		productsRepositoty.delete(product);
		return modelMapper.map(product, ProductsDto.class);
	}

	@Override
	public ProductsDto getProduct(String productId) {
		Products product = productsRepositoty.findById(productId).orElseThrow(ProductNotFoundException::new);
		return modelMapper.map(product, ProductsDto.class);
	}

}
