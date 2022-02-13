package com.study.springcore.case08;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 
 * @author billshih
 * 功能：
 * 1. 建立Person 資料: 輸入name, birth
 * 2. 取得Person 全部資料
 * 3. 根據姓名取得 Person
 * 4. 取得今天生日的 Person
 * 5. 取得某一歲數以上的 Person
 * 6. 根據姓名修改 Person 的生日
 * 7. 根據姓名來刪除 Person
 */

@Controller
public class PersonController {
	
	@Autowired
	private PersonService personService;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	
	public void addPerson(String name, Date birth) {
		//1.檢查name 與 birth 是否有資料
		//2.建立Person 資料
		boolean check = personService.append(name, birth);
		System.out.println("add person : " + check);
	}
	
	public void addPerson(String name, int year, int month, int day) {
		//1.檢查name, year, month, day 是否有資料
		//2.將year, month ,day 轉換成日期格式
		String dateStr = year + "/" + month + "/" + day;
		try {
			Date birth = sdf.parse(dateStr);
			addPerson(name, birth);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void printAllPersons() {
		//System.out.println(personService.findAllPersons());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		// 資料呈現
		List<Person> people = personService.findAllPersons();
		System.out.println("+--------------+---------+--------------+");
		System.out.println("|     name     |   age   |   birthday   |"); // 12, 7, 12
		System.out.println("+--------------+---------+--------------+");
		for(Person p : people) {
			String birthday = sdf.format(p.getBirth());
			System.out.printf("| %-12s | %7d | %12s |\n", p.getName(), p.getAge(), birthday);
			System.out.println("+--------------+---------+--------------+");
		}
	}
	
	// 根據姓名取得 Person
	public void getPersonByName(String name) {
		// 1. 判斷 name ?
		// 2. 根據姓名取得 Person
		Person person = personService.getPerson(name);
		System.out.println(person != null ? person : "找不到名字為" + name + "的 Person ");
	}
	
	// 取得今天生日的 Person
	public void getPersonByBirth(int year, int month, int day) {
		Person person = personService.getPerson(year, month, day);
		String dateStr = year + "/" + month + "/" + day;
		System.out.println(person != null ? person : dateStr + " 這天沒有人生日");		
	}
	
	//取得某一歲數以上的 Person
	public void getPersonAboveAge(int age) {
		List<Person> people = personService.findAllPersonAboveAge(age);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		System.out.println("+--------------+---------+--------------+");
		System.out.println("|     name     |   age   |   birthday   |"); // 12, 7, 12
		System.out.println("+--------------+---------+--------------+");
		for(Person p : people) {
			String birthday = sdf.format(p.getBirth());
			System.out.printf("| %-12s | %7d | %12s |\n", p.getName(), p.getAge(), birthday);
			System.out.println("+--------------+---------+--------------+");
		}
	}
	
	//根據姓名來修改Person的生日
	public void modifyPerson(String name, int year, int month, int day) {
		String dateStr = year + "/" + month + "/" + day;
		Person person = personService.getPerson(name);
		if(person != null) {
			try {
				Date birth = sdf.parse(dateStr);
				person.setBirth(birth);
				modify(person);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("查無名字為" + name + "的 Person");
		}
	}
	
	public void modify(Person person) {
		boolean check = personService.modify(person);
		System.out.println("修改 Person 資料 " + (check ? "成功" : "失敗"));
	}
	
	//根據姓名來刪除Person
	public void removePerson(String name) {
		Person person = personService.getPerson(name);
		if(person != null) {
			remove(person);
		}else {
			System.out.println("查無名字為" + name + "的 Person");
		}
	}
	
	public void remove(Person person) {
		boolean check = personService.remove(person);
		System.out.println("刪除 Person 資料 " + (check ? "成功" : "失敗"));
	}
}
