package com.xinyue.micromall.spi.integral.service;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.xinyue.micromall.spi.integral.bean.IntegralHystrixImpl;

@FeignClient(value="micro-mall-integral",fallback=IntegralHystrixImpl.class)
public interface IntegralService {
	
	@RequestMapping(value = "/increa", method = RequestMethod.GET)
	public String increa(@RequestParam Map<String, Object> param); 

}
