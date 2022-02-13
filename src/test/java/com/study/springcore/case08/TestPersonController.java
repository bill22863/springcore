package com.study.springcore.case08;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestPersonController {

	public static void main(String[] args) throws ParseException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext8.xml");
		PersonController personController = ctx.getBean("personController", PersonController.class);
		/**
		personController.printAllPersons();
		
		personController.addPerson("Bob", 2013, 12, 26);
		
		personController.printAllPersons();
		*/
		
		//System.out.println(personController.getPersonByName("Randy"));
		//System.out.println(personController.getPersonByName("Tom"));
	}

}
