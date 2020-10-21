/**
 * @Title: GatewayApplication.java 
 * @Package com.xinyue.micromall.gateway 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author A18ccms A18ccms_gmail_com   
 * @date 2020年10月19日 下午5:36:53 
 *@Copyright:Copyright (c) 
 *@Company:whtyAdministrator
 * @version V1.0 
 */
package com.xinyue.micromall.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName: GatewayApplication
 * @Title:
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @Author:Administrator
 * @Since:2020年10月19日下午5:36:53
 * @Version:1.0
 */

@EnableDiscoveryClient
@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
}
