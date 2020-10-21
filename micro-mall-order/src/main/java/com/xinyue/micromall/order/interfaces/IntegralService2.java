package com.xinyue.micromall.order.interfaces;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.xinyue.micromall.order.interfaces.hystrix.IntegralHystrix2Impl;

@FeignClient(name = "micro-mall-integral", fallback = IntegralHystrix2Impl.class)
public interface IntegralService2 {

	@RequestMapping(value = "/increa", method = RequestMethod.GET)
	public String increa(@RequestParam Map<String, Object> param);

}
