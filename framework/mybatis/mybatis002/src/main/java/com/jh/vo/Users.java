package com.jh.vo;

/**
 * 实体类，对应test数据库中的users表
 *
 * @ClassName: Users
 * @author jh
 * @date 2016年4月18日 下午7:44:21
 * 
 */
public class Users {
	/**
	 * id
	 */
	private String id;
	/**
	 * 名字
	 */
	private String name;
	/**
	 * 年龄
	 */
	private int age;
	private Dept dept;

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

}
