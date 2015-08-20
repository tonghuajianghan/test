package com.excute.action;

import com.excute.model.User;

public class UserManagerAction {
	private String name;
	private int age;

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

	public String execute() {
		System.out.println("user.name=" + name);
		System.out.println("user.age=" + age);
		return "success";
	}

	public String addUser() {
		User u = new User();
		u.setAge(age);
		u.setName(name);
		System.out.println("u.name=" + u.getName());
		System.out.println("u.age=" + u.getAge());
		return "addUser";
	}
	
	public String getUserIndex(){
		return "indexofuser";
	}

}
