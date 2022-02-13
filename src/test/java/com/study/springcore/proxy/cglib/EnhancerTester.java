package com.study.springcore.proxy.cglib;

public class EnhancerTester {
	public static void main(String[] args) {
		//使用子類別 (加強) 來代理
		Customer customer = new EnhancerCustomer();
		System.out.println(customer.buy("飲料"));
	}
}
