package com.study.springcore.case04;

public class JPY extends CurrencyImpl {
	private double value;
	
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

}
