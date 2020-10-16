/**
 * @Title: IntegralApplication.java 
 * @Package com.xinyue.micromall.integral 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author A18ccms A18ccms_gmail_com   
 * @date 2020年10月16日 下午4:58:35 
 *@Copyright:Copyright (c) 
 *@Company:whtyAdministrator
 * @version V1.0 
 */
package com.xinyue.micromall.integral;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;

/**
 * @ClassName: IntegralApplication
 * @Title:
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @Author:Administrator
 * @Since:2020年10月16日下午4:58:35
 * @Version:1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@NacosPropertySource(dataId = "micro-mall-integral", autoRefreshed = true, groupId = "micromall")
public class IntegralApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntegralApplication.class, args);
	}
}
