package com.hibernate.vo;

public class Husband {
   private int id;
   private  String name;
   private int age;
   private Wife wid;
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
public Wife getWid() {
	return wid;
}
public void setWid(Wife wid) {
	this.wid = wid;
}
   
}
