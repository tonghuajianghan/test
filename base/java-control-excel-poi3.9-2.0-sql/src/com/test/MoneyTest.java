package com.test;

import java.sql.Date;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.hibernate.vo.Money;
import com.hibernate.vo.Student;

public class MoneyTest {
@SuppressWarnings("deprecation")
public static void main(String[] args) {
	 Money m = new Money();
	 m.setId(3);
	 m.setMoney(12345);
	 
	 Configuration cfg = new Configuration();
	 SessionFactory sf = cfg.configure().buildSessionFactory();
	 Session session = sf.openSession();
	 session.beginTransaction();
	 session.save(m);
	 session.getTransaction().commit();
	 session.close();
	 sf.close();
	 
  }
}
