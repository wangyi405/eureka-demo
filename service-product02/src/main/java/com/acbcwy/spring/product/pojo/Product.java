package com.acbcwy.spring.product.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
	private String id;
	private String name;
	private int quantity;
	private double price;

}
