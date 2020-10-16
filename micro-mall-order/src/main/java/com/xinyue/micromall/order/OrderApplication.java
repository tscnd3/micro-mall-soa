/**
 * @Title: OrderApplication.java 
 * @Package com.xinyue.micromall.order 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author A18ccms A18ccms_gmail_com   
 * @date 2020年10月16日 上午11:47:28 
 *@Copyright:Copyright (c) 
 *@Company:whtyAdministrator
 * @version V1.0 
 */
package com.xinyue.micromall.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;

/**
 * @ClassName: OrderApplication
 * @Title:
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @Author:Administrator
 * @Since:2020年10月16日上午11:47:28
 * @Version:1.0
 */

@SpringBootApplication
@EnableDiscoveryClient
// feign处理ribbno可以你像本地方法调用服务
@EnableFeignClients
// 开启断路器
@EnableCircuitBreaker
@NacosPropertySource(dataId = "micro-mall-order", autoRefreshed = true, groupId = "micromall")
public class OrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}

	@LoadBalanced // 开启负载均衡
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
