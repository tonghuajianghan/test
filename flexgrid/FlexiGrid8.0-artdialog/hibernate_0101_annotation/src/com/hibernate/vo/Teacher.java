package com.hibernate.vo;

import javax.persistence.Entity;
import javax.persistence.Id;

/*
 * 这是测试annocation的一个类
 */

@Entity
public class Teacher {
	
    private int id;
    private String name;
    private String title;
    
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

  
}
