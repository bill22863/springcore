package com.study.springcore.case08;

import java.util.Date;
import java.util.List;


public interface PersonService {
	boolean append(String name, Date birth);
	boolean append(Person person);
	boolean modify(Person person);
	boolean modify(Person person, Date birth);
	boolean remove(Person person);
	List<Person> findAllPersons();
	List<Person> findAllPersonAboveAge(int age);
	Person getPerson(String name);
	Person getPerson(int year, int month, int day);
}
