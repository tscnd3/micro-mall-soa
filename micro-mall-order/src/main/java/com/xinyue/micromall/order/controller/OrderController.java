/**
 * @Title: OrderController.java 
 * @Package com.xinyue.micromall.order.controller 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author A18ccms A18ccms_gmail_com   
 * @date 2020年10月16日 下午3:59:54 
 *@Copyright:Copyright (c) 
 *@Company:whtyAdministrator
 * @version V1.0 
 */
package com.xinyue.micromall.order.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * @ClassName: OrderController
 * @Title:
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @Author:Administrator
 * @Since:2020年10月16日下午3:59:54
 * @Version:1.0
 */

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private DiscoveryClient discoveryClient;

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/getServiceList")
	public List<ServiceInstance> getServiceList() {
		List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("micro-mall-order");
		return serviceInstanceList;
	}

	@RequestMapping(value = "/createOrder2", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "createOrderFallback")
	public String createOrder(@RequestParam Map<String, Object> param) {
		// 1.根据用户信息商品信息产生订单。
		// 2.扣除库存商品数量
		// 3.给用户增加积分
		String userId = param.get("userId") != null ? param.get("userId").toString() : null;
		int integral = 10;
		Map<String, Object> params = new HashMap<>();
		params.put("userId", userId);
		params.put("integral", integral);
		restTemplate.getForEntity("http://micro-mall-integral/integral/increa?userId={userId}?integral={integral}",
				String.class, params).getBody();
		return "success";
	}

	public String createOrderFallback(Map<String, Object> param) {
		return "error";
	}

}
