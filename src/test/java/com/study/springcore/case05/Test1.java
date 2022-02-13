package com.study.springcore.case05;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext5.xml");
		
		Student john = ctx.getBean("s1", Student.class);
		System.out.println(john);
		
		Student mary = ctx.getBean("s2", Student.class);
		System.out.println(mary);
		
		//mary `s teacher
		/**
		String result = "";
		
		for(Clazz course : mary.getClazzs()) {
			String c = course.getName();
			Teacher t1 = ctx.getBean("t1", Teacher.class);
			
			for(Clazz tmpClazz : t1.getClazzs()) {
				if(tmpClazz.getName().equals(c)) {
					result += t1.getName();
					result += ",";
					break;
				}
			}
			
			Teacher t2 = ctx.getBean("t2", Teacher.class);
			
			for(Clazz tmpClazz : t2.getClazzs()) {
				if(tmpClazz.getName().equals(c)) {
					result += t2.getName();
					result += ",";
					break;
				}
			}
		}
		System.out.println(result);
		*/
		
		//講師解法
	
		/*Teacher[] teachers = {ctx.getBean("t1", Teacher.class), ctx.getBean("t2", Teacher.class)};
		Set<Teacher> result = new LinkedHashSet<Teacher>();
		for(Teacher teacher : teachers) {
			clazz_loop:
			for(Clazz clazz1 : teacher.getClazzs()) {
				for(Clazz clazz2 : mary.getClazzs()) {
					if(clazz1.getId() == clazz2.getId()) {
						result.add(teacher);
						break clazz_loop;
					}
				}
			}
		}
		System.out.println(mary.getName() + "的老師: " + result);
		System.out.println(mary.getName() + "的老師: " + result.stream().map(Teacher::getName)
																	.collect(Collectors.toSet()));
		*/
		
		//homework
		Teacher[] teachers = {ctx.getBean("t1", Teacher.class), ctx.getBean("t2", Teacher.class)};
		Stream<Teacher> teacherStream =  Stream.of(teachers);
		
	
		//first loop
		teacherStream.forEach(teacher -> {
			//second loop for teacher courses
			teacher.getClazzs().stream().forEach(course -> {
				//third loop for mary courses
				mary.getClazzs().stream().filter(c -> course.getId() == c.getId()).forEach(t -> {
					System.out.println("Mary`s teahcer :" + teacher.getName());
				});
			});
		});
	}
}
