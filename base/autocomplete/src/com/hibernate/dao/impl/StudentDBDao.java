package com.hibernate.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.hibernate.dao.StudentDao;
import com.hibernate.vo.Student;

public class StudentDBDao implements StudentDao {
	public List<Student> getStudentById(){
		Configuration cfg = new Configuration();
		SessionFactory sf = cfg.configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
	    //HQLÓï¾ä
	       Query query = session.createQuery("from Student");
	       List  peList = query.list();
	     /*  System.out.println("mark:"+peList.size());
	  	
	       for(int i = 0; i < peList.size();i++){
	  		 System.out.println("mark "+i);
	  		 Student stu =(Student)peList.get(i);
	  		 System.out.println(stu.getName());
	  	 }*/

		session.getTransaction().commit();
		session.close();
		sf.close();
		return peList;
	}
	
	
	/*public List<Student> getAuthorByPageAndProject(){
		try {
			Configuration cfg = new Configuration();
			SessionFactory sf = cfg.configure().buildSessionFactory();
			Session session = sf.openSession();
			session.beginTransaction();
			Query q = null;
			String sql="from Student s where );
			q=session.createQuery(sql);
			q.setFirstResult((pagination.getPage()-1)*pagination.getSize());
			q.setMaxResults(pagination.getSize());
			session.save(s);
			session.getTransaction().commit();
			session.close();
			sf.close();
			return q.list();
		} catch (HibernateException ex) {
			if (logger.isWarnEnabled()) {
				logger.warn("",ex);
			}
			ex.printStackTrace();
		}
		return null;
		
		
		
	}*/
}
