package com.hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConnectBasic {
   private Configuration cfg = null;
   private SessionFactory sf = null;
   private Session session = null;
   public Session connectionMain(){
	     cfg = new Configuration();
		 sf = cfg.configure().buildSessionFactory();
		 session = sf.openSession();
		 session.beginTransaction();
		 return session;
   }
   public void stopConnection(){
	     session.getTransaction().commit();
		 session.close();
		 sf.close();
   }
}
