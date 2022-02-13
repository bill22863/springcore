package com.study.springcore.case08;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDaoImpl implements PersonDao {
	
	@Autowired
	private JsonDB jsonDB;
	
	@Override
	public boolean create(Person person) {
		Boolean check = null;
		try {
			check = jsonDB.add(person);
		} catch (Exception e) {
			e.printStackTrace();
			check = false;
		}
		return check;
	}

	@Override
	public List<Person> readAll() {
		List<Person> result = null;
		try {
			result = jsonDB.queryAll();
		} catch (Exception e) {
			e.printStackTrace();			
		}
		return result;
	}

	@Override
	public boolean modify(Person person) {
		Boolean check = null;
		try {
			check = jsonDB.modify(person);
		} catch (Exception e) {
			e.printStackTrace();
			check = false;
		}
		return check;
	}

	@Override
	public boolean delete(Person person) {
		Boolean check = null;
		try {
			check = jsonDB.delete(person);
		} catch (Exception e) {
			e.printStackTrace();
			check = false;
		}
		return check;
	}

}
