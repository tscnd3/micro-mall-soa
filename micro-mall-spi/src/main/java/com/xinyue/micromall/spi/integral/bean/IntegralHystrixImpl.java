package com.xinyue.micromall.spi.integral.bean;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.xinyue.micromall.spi.integral.service.IntegralService;

@Service
public class IntegralHystrixImpl implements IntegralService {

	@Override
	public String increa(Map<String, Object> param) {
		return "-9999";
	}

}
