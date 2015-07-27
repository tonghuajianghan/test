

package com.test;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.hibernate.vo.Husband;
import com.hibernate.vo.Student;

public class OneToOneTest {
  public static void main(String[] args) {
	 Configuration cfg = new Configuration();
	 SessionFactory sf = cfg.configure().buildSessionFactory();
	 Session session = sf.openSession();
	 session.beginTransaction();
	/* Student stu =(Student)session.get(Student.class, 2);
	 if(stu.getId() != 0){
	      System.out.print(stu.getName());
	 }else{
		 System.out.print("nullme");
	 }*/
	 ///////////////////////
	 Husband hs =(Husband)session.get(Husband.class, 2);
	 System.out.print(hs.getName());
	 session.getTransaction().commit();
	 session.close();
	 sf.close();
	 
  }
}
