package com.study.springcore.aop;

import org.springframework.stereotype.Component;

@Component
public class CalcImpl implements Calc {

	@Override
	public Integer add(Integer x, Integer y) {
		System.out.println("執行 add()");
		Integer result = x + y;
		return result;
	}

	@Override
	public Integer div(Integer x, Integer y) {
		System.out.println("執行 div()");
		Integer result = x / y;
		return result;
	}
	
	

}
