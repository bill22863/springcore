package com.study.springcore.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1) //數字愈小愈先執行(預設是int的最大值)
public class MyLoggerAspect {
	//前置通知
	@Before(value = "execution(* com.study.springcore.aop.CalcImpl.*(..))")
	public void before(JoinPoint joinPoint) {
		System.out.printf("%s %s %s\n", 
				"前置通知", 
				joinPoint.getSignature().getName(), 
				Arrays.toString(joinPoint.getArgs()));
	}	
}
