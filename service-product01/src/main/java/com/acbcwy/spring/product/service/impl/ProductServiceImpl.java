package com.acbcwy.spring.product.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.acbcwy.spring.product.pojo.Product;

@Service
public class ProductServiceImpl implements com.acbcwy.spring.product.service.ProductService {
    Map<String,Product> productMap=new HashMap<>();
    
    public ProductServiceImpl(){
    	productMap.put("1", new Product("1","苹果手机-01",2,9999.0));
    	productMap.put("2", new Product("2","小米手机-01",10,5999.0));
    	productMap.put("3", new Product("3","美的空调-01",5,3999.0));
    	productMap.put("4", new Product("4","特斯拉汽车-01",1,309999.0));
    	
    }
	
	@Override
	public List<Product> findAllProduct() {
		List<Product> result=new ArrayList<>(); 
		result.addAll(productMap.values());
		return result;
	}

	@Override
	public Product findProductById(String id) {		  
		return productMap.get(id);
	}

}
