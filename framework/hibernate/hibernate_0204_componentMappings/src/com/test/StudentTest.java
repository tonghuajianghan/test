package com.test;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.hibernate.vo.Student;

public class StudentTest {
  public static void main(String[] args) {
	 Student s = new Student();
	 s.setId(99);
	// s.setName("daxian");
	 s.setAge(100);
	 Configuration cfg = new Configuration();
	 SessionFactory sf = cfg.configure().buildSessionFactory();
	 Session session = sf.openSession();
	 session.beginTransaction();
	 session.save(s);
	 session.getTransaction().commit();
	 session.close();
	 sf.close();
	 
  }
}
