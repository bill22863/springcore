package com.study.springcore.case08;

import java.util.List;

public interface PersonDao {
	//create person
	public boolean create(Person person);
	//modify person
	public boolean modify(Person person);
	//delete person
	public boolean delete(Person person);
	//query all 
	public List<Person> readAll();
	
}
