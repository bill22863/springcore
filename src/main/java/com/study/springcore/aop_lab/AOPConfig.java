package com.study.springcore.aop_lab;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

//使用Java配置來替代xml
@Configuration //此類別為配置檔
@EnableAspectJAutoProxy //啟動AOP自動代理器
@ComponentScan //啟動自動掃瞄
public class AOPConfig {
	@Bean(name = "dancer")
	public Performance dancer() {
		return new Dancer();
	}
	
	@Bean
	public Audience audience() {
		return new Audience();
	}
	
	@Bean
	public Introducter getIntroducter() {
		return new Introducter();
	}
}