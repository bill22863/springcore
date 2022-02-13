package com.study.springcore.aop_lab;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Audience {
	
	//切面表達式可以指向interface
	@Pointcut(value = "execution(* com.study.springcore.aop_lab.Performance.perform(..))")
	public void pt() {}
	
	@Before(value = "pt()")
	public void slienceCellPhone() {
		System.out.println("觀眾 : 進入表演場");
		System.out.println("觀眾 : 手機靜音");
		System.out.println("觀眾 : 找到位置");
	}
	
	@AfterReturning(value = "pt()")
	public void applause() {
		System.out.println("觀眾 : 鼓掌");
		System.out.println("觀眾 : 離開表演場");
	}
	
	@AfterThrowing(value = "pt()")
	public void accident() {
		System.out.println("觀眾 : 加油");
	}
	
}
