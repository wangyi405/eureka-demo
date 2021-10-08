package com.acbcwy.spring.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.acbcwy.spring.product.pojo.Product;
import com.acbcwy.spring.product.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService  productService;
	
	@GetMapping("/list")
	public List<Product> findAllProduct(){
		return productService.findAllProduct();
	}
	
	@GetMapping("/{id}")
	public Product findProductById(@PathVariable String id){
		return productService.findProductById(id);
	}
}
