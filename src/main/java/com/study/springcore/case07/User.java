package com.study.springcore.case07;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author billshih
 * 若於配置文件中有設定<context:include-filter type="assignable" expression="com.study.springcore.case07.User"/>
 * 則此類別不用加註 ＠Component
 */
//@Component
public class User {
	
	@Value(value = "Bill")
	private String name;
	
	@Value(value = "28")
	private Integer age;

	@Value("#{${nicknames:{'Happy', 'Enjoy'}}}") //Spring EL, 少用
	private String[] nicknames;
	
	@Value("#{${subjects:{'英文', 'math', 'physic'}}}")
	private Set<String> subjects;
	
	@Value("#{${scores:{100, 90, 80}}}")
	private List<Integer> scores;
		
	@Value("#{${hobbies:{1: 'travel', 2: 'shopping' }}}")
	private Map<Integer, String> hobbies;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	

	public String[] getNicknames() {
		return nicknames;
	}

	public void setNicknames(String[] nicknames) {
		this.nicknames = nicknames;
	}

	public Set<String> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<String> subjects) {
		this.subjects = subjects;
	}

	public List<Integer> getScores() {
		return scores;
	}

	public void setScores(List<Integer> scores) {
		this.scores = scores;
	}

	public Map<Integer, String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(Map<Integer, String> hobbies) {
		this.hobbies = hobbies;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", nicknames=" + Arrays.toString(nicknames) + ", subjects="
				+ subjects + ", scores=" + scores + ", hobbies=" + hobbies + "]";
	}
}
