package com.xinyue.micromall.order.interfaces.hystrix;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.xinyue.micromall.order.interfaces.IntegralService2;

@Service
public class IntegralHystrix2Impl implements IntegralService2 {

	@Override
	public String increa(Map<String, Object> param) {
		return "-9999";
	}

}
