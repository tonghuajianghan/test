//hibernate提供的save方法使用

package com.Text;
import com.hibernate.vo.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.Session;

public class StudentText {
	public static void main(String[] args) {
       Student s = new Student();
       s.setId(63336);
       s.setName("为啥");
       s.setAge(23);
              
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
