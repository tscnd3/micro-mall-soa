/**
 * @Title: IntegralController.java 
 * @Package com.xinyue.micromall.integral.controller 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author A18ccms A18ccms_gmail_com   
 * @date 2020年10月16日 下午5:19:22 
 *@Copyright:Copyright (c) 
 *@Company:whtyAdministrator
 * @version V1.0 
 */
package com.xinyue.micromall.integral.controller;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * @ClassName: IntegralController
 * @Title:
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @Author:Administrator
 * @Since:2020年10月16日下午5:19:22
 * @Version:1.0
 */
@RestController
@RequestMapping("/integral")
public class IntegralController {

	// @ResponseBody
	@RequestMapping(value = "/increa", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "increaFallback")
	public String increa(@RequestParam Map<String, Object> param) {
		// 给用户增加积分
		String userId = param.get("userId") != null ? param.get("userId").toString() : null;
		Integer increa = param.get("integral") != null ? StringUtils.isNotBlank(param.get("integral").toString())
				? Integer.valueOf(param.get("integral").toString()) : null : null;
		System.out.println("userId=" + userId + ",increa=" + increa);
		return "success";
	}

	public String increaFallback() {
		return "error";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
		Integer r = a + b;
		return r;
	}

}
