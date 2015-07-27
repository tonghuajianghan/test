package com.excute.model;

public class User {
	private String name;
    private int age;
    public String getName() {
		return name;
	}
    public User(){
    	name = null;
    	age = 0;
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
