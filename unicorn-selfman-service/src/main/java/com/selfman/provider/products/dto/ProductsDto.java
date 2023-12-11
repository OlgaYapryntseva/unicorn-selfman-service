package com.selfman.provider.products.dto;

import java.util.List;

import lombok.Getter;

@Getter
public class ProductsDto {
	String name;
	String minimumOrderQuantity;
	Integer price;
	List<String> images;
}
