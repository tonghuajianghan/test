package com.hibernate.dao;

import java.util.List;

import com.hibernate.vo.Student;

public interface StudentDao {
	//通过id获取student的数据
	public List<Student> getStudentById() throws Exception;
}
