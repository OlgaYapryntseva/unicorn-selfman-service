package com.selfman.provider.products.model;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Document(collection = "products")
public class Products {
	@Id
	String productId;
	
//	@Indexed(unique = true)
	String providerEmail;
	
//	@Indexed(unique = true)
	String name;
	
	String minimumOrderQuantity;
	Integer price;
	List<String> images;
	
	
	public Products() {
		this.images = new ArrayList<String>();
	}

}
