package com.study.springcore.aop;

import org.springframework.stereotype.Component;

@Component
public class CalcImpl implements Calc {

	@Override
	public Integer add(int x, int y) {
		Integer result = x + y;
		return result;
	}

}
