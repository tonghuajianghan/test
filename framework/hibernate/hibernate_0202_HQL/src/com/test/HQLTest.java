//s与s1的名字不可以一样



package com.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.hibernate.vo.Student;

public class HQLTest {
  public static void main(String[] args) {
	 Configuration cfg = new Configuration();
	 SessionFactory sf = cfg.configure().buildSessionFactory();
	 Session session = sf.openSession();
	 session.beginTransaction();
     //属性查询
	 Query query = session.createQuery("select s.name from Student s");
	 List list = query.list();
	 for(int i = 0; i < list.size();i++){
		 String name = (String)list.get(i);
		 System.out.println(name);
	 }
	 
	 //多属性查询
	 Query query1 = session.createQuery("select s1.name,s1.age from Student as s1");
	 List list1 = query1.list();
	 for(int i = 0; i < list1.size();i++){
		 Object obj[] = (Object[])list1.get(i);
		 System.out.println(obj[0] + "的名字为：" + obj[1]);
	 }
	 
	 //实例化查询
	 Query query2 = session.createQuery("select new Student(s2.name ,  s2.age) from Student s2");
	 List list2 = query2.list();
	 for(int i = 0; i < list2.size();i++){
		 Student s2 = (Student) list2.get(i);
		 System.out.println(s2.getName());
	 }
	 //连接查询
	 
	 
	 session.getTransaction().commit();
	 session.close();
	 sf.close();
	 
  }
}
