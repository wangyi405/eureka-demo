package com.acbcwy.spring.product.service;

import java.util.List;

import com.acbcwy.spring.product.pojo.Product;

public interface ProductService {

	public List<Product> findAllProduct();
	
	public Product findProductById(String id);
}
