package com.study.springcore.case08;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJsonDB {

	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext8.xml");
		JsonDB jsonDB = ctx.getBean("jsonDB", JsonDB.class);
		System.out.println(jsonDB.queryAll());
		System.out.println("total : " + jsonDB.queryAll().size());
		
		jsonDB.add(new Person("Randy", 54 , new SimpleDateFormat("yyyy/MM/dd").parse("1968/12/06")));
		System.out.println("after total : " + jsonDB.queryAll().size());
		
	}

}
