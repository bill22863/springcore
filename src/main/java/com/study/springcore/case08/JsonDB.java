package com.study.springcore.case08;

import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Component
//Json database
public class JsonDB {
	@Autowired
	private Gson gson;
	
	//Json File 資料庫存放路徑
	private static final Path PATH = Paths.get("src/main/java/com/study/springcore/case08/person.json");
	
	//查詢全部
	public List<Person> queryAll() throws Exception {
		
		String jsonStr = Files.readAllLines(PATH).stream().collect(Collectors.joining());
		Type type = new TypeToken<ArrayList<Person>>() {
			
		}.getType();
		List<Person> people = gson.fromJson(jsonStr, type);
		Date today = new Date();
	
		/**
		LocalDate todayLocalDate = today.toInstant().
				atZone(ZoneId.systemDefault()).toLocalDate();
		
		//請將age變為最新年齡(Java 8 )
		//方法一
		for(Person person : people) {
			LocalDate birthLocalDate = person.getBirth().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			int age = todayLocalDate.getYear() - birthLocalDate.getYear();
			person.setAge(age);
		}
		*/
		//方法二
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);
		int currentYear = calendar.get(Calendar.YEAR);
		for(Person person : people) {
			calendar.setTime(person.getBirth());
			int birthYear = calendar.get(Calendar.YEAR);
			int age = currentYear - birthYear;
			person.setAge(age);
		}
		return people;
	}
	
	public Boolean add(Person person) throws Exception {
		List<Person> personList = queryAll();
		//作業 1 : if person exist , return false
		//name, age, birth 皆與db 資料相同
		for(Person p : personList) {
			if(p.equals(person)) {
				return false;
			}
		}
		
		personList.add(person);
		String newJsonStr = gson.toJson(personList);
		Files.write(PATH, newJsonStr.getBytes("UTF-8"));
		return true;
	}
	
	public Boolean modify(Person person) throws Exception {
		List<Person> people = queryAll();
		for(Person p : people) {
			if(p.getName().equals(person.getName())) {
				p.setBirth(person.getBirth());
			}
		}
		String newJsonStr = gson.toJson(people);
		Files.write(PATH, newJsonStr.getBytes("UTF-8"));
		return true;
	}
	
	public Boolean delete(Person person) throws Exception {
		List<Person> people = queryAll();
		List<Person> newPeople = new ArrayList<Person>();
		System.out.println("刪除前資料共" + people.size() + "筆");
		
		for(Person p : people) {
			if(!p.getName().equals(person.getName())) {
				newPeople.add(p);
			}
		}
		System.out.println("刪除後資料共" + newPeople.size() + "筆");
		
		String newJsonStr = gson.toJson(newPeople);
		Files.write(PATH, newJsonStr.getBytes("UTF-8"));
		return true;
	}
}
