package com.hibernate.vo;

import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class Student {
	private int id;
	private String name;
	private int age;
	
	@Id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
}
