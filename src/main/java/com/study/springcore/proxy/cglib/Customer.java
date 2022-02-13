package com.study.springcore.proxy.cglib;

public class Customer {
	
	//方法簽章(規格)
	public  String buy(String data) {
		return "買了" + data;
	}
}
