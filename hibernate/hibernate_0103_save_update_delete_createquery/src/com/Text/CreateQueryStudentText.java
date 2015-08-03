//hibernate提供的save方法使用

package com.Text;
import java.util.List;

import com.hibernate.vo.*;

import org.hibernate.cfg.Configuration;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Session;

public class CreateQueryStudentText {
	public static void main(String[] args) {

              
       Configuration cfg = new Configuration();     
       SessionFactory sf = cfg.configure().buildSessionFactory();      
       Session session = sf.openSession();     
       session.beginTransaction();
    
       //HQL语句
       Query query = session.createQuery("from Student");
       List  peList = query.list();
       System.out.println("mark:"+peList.size());
  	
       for(int i = 0; i < peList.size();i++){
  		 System.out.println("mark "+i);
  		 Student stu =(Student)peList.get(i);
  		 System.out.println(stu.getName());
  	 }
       
       session.getTransaction().commit();
       session.close();
       sf.close();
       
	}
}
