

package com.test;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.hibernate.vo.Husband;

public class ManyToOneTest {
  public static void main(String[] args) {
	 Configuration cfg = new Configuration();
	 SessionFactory sf = cfg.configure().buildSessionFactory();
	 Session session = sf.openSession();
	 session.beginTransaction();
	
	 Husband hs =(Husband)session.get(Husband.class, 1);
	 System.out.println(hs.getName());
	 session.getTransaction().commit();
	 session.close();
	 sf.close();
	 
  }
}
