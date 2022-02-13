package com.study.springcore.case04;

public class USD extends CurrencyImpl {

	public void init() {
		System.out.println("USD init()");
	}
	
	@Override
	public double getValue() {
		// TODO Auto-generated method stub
		return value;
	}

	@Override
	public void setValue(double value) {
		// TODO Auto-generated method stub
		this.value = value;
	}
	
	public void destroy() {
		System.out.println("USD destroy()");
	}

}
