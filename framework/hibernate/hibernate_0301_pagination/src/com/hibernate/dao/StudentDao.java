package com.hibernate.dao;

import java.util.List;

import com.hibernate.vo.Student;

public interface StudentDao {
	//ͨ��id��ȡstudent������
	public List<Student> getStudentById() throws Exception;
}
