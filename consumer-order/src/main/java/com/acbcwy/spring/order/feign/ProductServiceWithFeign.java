package com.acbcwy.spring.order.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.acbcwy.spring.order.pojo.Product;

@FeignClient("PRODUCT-SERVICE")
public interface ProductServiceWithFeign  {
	@GetMapping("/product/list")
	public List<Product> findAllProduct();
	
	@GetMapping("/product/{id}")
	public Product findProductById(String id);

}
