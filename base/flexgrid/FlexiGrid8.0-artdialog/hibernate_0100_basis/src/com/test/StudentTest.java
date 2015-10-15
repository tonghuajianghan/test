package com.test;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.hibernate.vo.Student;

public class StudentTest {
  public static void main(String[] args) {
	 System.out.print("hh");
	 Student s = new Student();
	 s.setId(113);
	 s.setName("daxian");
	 s.setAge(100);
	 //hibernate链接数据库的配置
	 System.out.print("hh2");
	 Configuration cfg = new Configuration();
	 SessionFactory sf = cfg.configure().buildSessionFactory();
	 Session session = sf.openSession();
	 session.beginTransaction();
	 //对实体类进行插入
	 session.save(s);
	 session.getTransaction().commit();
	 session.close();
	 sf.close();
	 
  }
  public void hh(){
	  
  }
}
