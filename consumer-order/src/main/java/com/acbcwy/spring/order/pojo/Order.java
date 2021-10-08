package com.acbcwy.spring.order.pojo;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable{
	private String orderId;
	private String orderName;
	private List<Product> productList;

}
