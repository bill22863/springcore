package com.study.springcore.case08;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDao personDao;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	
	@Override
	public boolean append(String name, Date birth) {
		Person person = new Person();
		person.setName(name);
		person.setBirth(birth);
		return append(person);
	}

	@Override
	public boolean append(Person person) {
		return personDao.create(person);
	}

	@Override
	public List<Person> findAllPersons() {
		return personDao.readAll();
	}

	@Override
	public Person getPerson(String name) {
		Optional<Person> optPerson = findAllPersons().stream()
				.filter(p -> p.getName().equals(name))
				.findFirst();
		return optPerson.isPresent() ? optPerson.get() : null;
	}

	@Override
	public Person getPerson(int year, int month, int day) {
		String dateStr = year + "/" + month + "/" + day;
		Optional<Person> optPerson = null;
		try {
			Date currDate = sdf.parse(dateStr);
			optPerson = findAllPersons().stream()
					.filter(p -> p.getBirth().equals(currDate))
					.findFirst();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return optPerson.isPresent() ? optPerson.get() : null;
	}

	@Override
	public List<Person> findAllPersonAboveAge(int age) {
		List<Person> result = new ArrayList<Person>();
		for(Person person : findAllPersons()) {
			if(person.getAge() >= age) {
				result.add(person);
			}
		}
		return result;
	}

	@Override
	public boolean modify(Person person, Date birth) {
		person.setBirth(birth);
		return modify(person);
		
	}

	@Override
	public boolean modify(Person person) {
		return personDao.modify(person);
	}

	@Override
	public boolean remove(Person person) {
		return personDao.delete(person);
	}
}
