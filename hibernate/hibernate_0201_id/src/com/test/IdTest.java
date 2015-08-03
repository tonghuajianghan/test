//get()方法使用，根据id从数据库中取出相应的一行数据
//load()方法...
//报错：notfoundpoundexception是数据库的列名与实体类名不对应


package com.test;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.hibernate.vo.Student;

public class IdTest {
  public static void main(String[] args) {
	 Configuration cfg = new Configuration();
	 SessionFactory sf = cfg.configure().buildSessionFactory();
	 Session session = sf.openSession();
	 session.beginTransaction();
	 Student stu =(Student)session.get(Student.class, 1);
	 if(stu.getId() != 0){
	      System.out.print(stu.getName());
	 }else{
		 System.out.print("nullme");
	 }
	 ///////////////////////
	 Student stu1 =(Student)session.load(Student.class, 2);
	 System.out.print(stu1.getName());
	 session.getTransaction().commit();
	 session.close();
	 sf.close();
	 
  }
}
