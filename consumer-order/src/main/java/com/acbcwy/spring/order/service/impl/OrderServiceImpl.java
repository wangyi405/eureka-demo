package com.acbcwy.spring.order.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acbcwy.spring.order.pojo.Order;
import com.acbcwy.spring.order.pojo.Product;
import com.acbcwy.spring.order.proxy.ProductServiceProxy;
import com.acbcwy.spring.order.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private ProductServiceProxy productServiceProxy;

	@Override
	public Order findOrderById(String orderId) {
		//List<Product> products=productServiceProxy.findProductListWithDiscoveryClient();
		//List<Product> products=productServiceProxy.findProductListWithLoadBalanceClient();
		//List<Product> products=productServiceProxy.findProductListWithAnnoation();
		List<Product> products=productServiceProxy.findProductListWithOpenFeign();
 		return new Order(orderId,"采购合同",products);
	}

	
}
