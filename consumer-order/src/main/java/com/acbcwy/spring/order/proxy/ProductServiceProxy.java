package com.acbcwy.spring.order.proxy;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.acbcwy.spring.order.feign.ProductServiceWithFeign;
import com.acbcwy.spring.order.pojo.Product;

@Component
public class ProductServiceProxy {
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private DiscoveryClient discoveryClient;
	@Autowired
	private LoadBalancerClient  loadBalancerClient;
	@Autowired
	private ProductServiceWithFeign productServiceWithFeign;
	
	/**第一种调用微服务的方法*/
	public List<Product> findProductListWithDiscoveryClient(){
		List<String> services= discoveryClient.getServices();
		System.out.println(services);
		
		List<ServiceInstance> serviceInstances = discoveryClient.getInstances("PRODUCT-SERVICE");
		if(CollectionUtils.isEmpty(serviceInstances)){
			return null;
		}
		StringBuilder sb=new StringBuilder();	
		String host=serviceInstances.get(0).getHost();
		int port=serviceInstances.get(0).getPort();
		sb.append("http://").append(host).append(":").append(port).append("/product/list");
		ResponseEntity<List<Product>> response = restTemplate.exchange(sb.toString(),HttpMethod.GET,null,new ParameterizedTypeReference<List<Product>>() {
		});
		
		return response.getBody();
	}
	
	/**第二种调用微服务方法(负载均衡)*/
	public List<Product> findProductListWithLoadBalanceClient(){
		ServiceInstance si = loadBalancerClient.choose("PRODUCT-SERVICE");
		if(si==null){
			return null;
		}
		StringBuilder sb=new StringBuilder();	
		String host=si.getHost();
		int port=si.getPort();
		sb.append("http://").append(host).append(":").append(port).append("/product/list");
		ResponseEntity<List<Product>> response = restTemplate.exchange(sb.toString(),HttpMethod.GET,null,new ParameterizedTypeReference<List<Product>>() {
		});
		return response.getBody();
	}

	/**第三种调用微服务方法(负载均衡)，RestTemplate注解@LoadBalanced*/
	public List<Product> findProductListWithAnnoation(){
		String url="http://PRODUCT-SERVICE/product/list";
		ResponseEntity<List<Product>> response = restTemplate.exchange(url,HttpMethod.GET,null,new ParameterizedTypeReference<List<Product>>() {
		});
		return response.getBody();
	}
	
	/**第4种调用微服务方法(负载均衡)，需要程序启动开启@EnableFeignClients*/
	public List<Product> findProductListWithOpenFeign(){
		return productServiceWithFeign.findAllProduct();
	}
}
