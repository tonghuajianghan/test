package com.hibernate.vo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="studentclass",catalog="hibernate")
public class StudentClass implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6891806450240469928L;
	
	private int classid;
	private String name;
	private Set<Student> stu = new HashSet<Student>(0);
	
	@GenericGenerator(name="generator",strategy="increment")
	@Id
	@GeneratedValue(generator="generator")
	@Column(name="classid",nullable = false, unique = true ,length = 2)
	public int getClassid() {
		return classid;
	}
	public void setClassid(int classid) {
		this.classid = classid;
	}
	
	@Column(name="name",nullable=false, unique=true)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//级联操作：cascade = CascadeType.ALL
	//延迟加载：fetch = FetchType.LAZY
	//映射：mappedBy = "category"
	//一对多方式
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "studentclass")
	public Set<Student> getStu() {
		return stu;
	}
	public void setStu(Set<Student> stu) {
		this.stu = stu;
	}
	
	

}
