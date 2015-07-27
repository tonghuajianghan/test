package com.test;

import java.util.List;

import com.hibernate.dao.StudentDao;
import com.hibernate.dao.impl.StudentDBDao;
import com.hibernate.vo.Student;

public class PageTest {
  public static void main(String[] args) throws Exception {
	StudentDao sd = new StudentDBDao();
	List<Student> list =  sd.getStudentById();
	
    System.out.println("mark:"+list.size());
  	
    for(int i = 0; i < list.size();i++){
		 System.out.println("mark "+i);
		 Student stu =(Student)list.get(i);
		 System.out.println(stu.getName());
	 }

	 
  }
}
