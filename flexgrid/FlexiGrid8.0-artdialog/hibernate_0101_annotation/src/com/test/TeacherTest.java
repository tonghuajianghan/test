package com.test;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.hibernate.vo.Teacher;

public class TeacherTest {
  public static void main(String[] args) {
	 Teacher t = new Teacher();
	 t.setId(4);
	 t.setName("hanhan");
	 t.setTitle("shanshan");
	  
	 Configuration cfg = new Configuration();
	 SessionFactory sf = cfg.configure().buildSessionFactory();
	 Session session = sf.openSession();
	 session.beginTransaction();
	 session.save(t);
	 session.getTransaction().commit();
	 session.close();
	 sf.close();
	 
  }
}
