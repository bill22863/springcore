package com.study.springcore.aop_lab;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PerformanceTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AOPConfig.class);
		Performance performance = ctx.getBean("dancer", Performance.class);
		try {
			performance.perform();
			
		} catch (Exception e) {
			System.out.println(e);
			//轉換跑道
			/*
			System.out.println("舞者轉為歌者");
			Singer singer = (Singer)performance;
			singer.sing();
			*/
			System.out.println("舞者轉為脫口秀主持");
			Actor actor = (Actor)performance;
			actor.show();
		}
		
	}

}
