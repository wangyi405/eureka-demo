package com.acbcwy.spring.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.acbcwy.spring.order.pojo.Order;
import com.acbcwy.spring.order.service.OrderService;

@RestController
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/{orderId}")
	public Order findById(@PathVariable String orderId){
		Order order=orderService.findOrderById(orderId);
		return order;
	}
}
