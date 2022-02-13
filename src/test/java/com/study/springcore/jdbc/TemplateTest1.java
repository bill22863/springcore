package com.study.springcore.jdbc;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.springcore.jdbc.template.EmpDao;

public class TemplateTest1 {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		EmpDao empDao = ctx.getBean("empDao", EmpDao.class);
		System.out.println(empDao.queryAll());
		
		//using java 8 stream to get name whose eid is 2
		List<Map<String, Object>> emps = empDao.queryAll();
		String ename = emps.stream()
			.filter( e -> (e.get("eid")+"").equals("2"))
			.findFirst()
			.get()
			.get("ename") + "";
		
		System.out.println(ename);
		
	}

}
