package com.test;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.hibernate.vo.Tree;

public class InhertanceMappingTest {
  public static void main(String[] args) {
	 Tree t = new Tree();
	 t.setId(12);
	 t.setName("Ê÷Ä¾¿Æ");
	 t.setTname("ÁøÊ÷");

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
