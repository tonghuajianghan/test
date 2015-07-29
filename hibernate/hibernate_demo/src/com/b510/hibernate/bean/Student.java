/**
 * 
 */
package com.b510.hibernate.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 学生类
 * @author hongten<br>
 * @date 2013-3-25
 */
@Entity
public class Student {

	private Integer id;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 学号
	 */
	private String no;
	/**
	 * 年龄
	 */
	private int age;

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	@Column(columnDefinition = "int default 0")
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
