/*//hibernate提供的delete
//对对象进行删除操作

package com.Text;
import com.hibernate.vo.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.Session;

public class DeleteStudentText {
	public static void main(String[] args) {
       Student s = new Student();
       s.setId(666666);
       s.setName("喊喊");
       s.setAge(23);
              
       Configuration cfg = new Configuration();     
       SessionFactory sf = cfg.configure().buildSessionFactory();      
       Session session = sf.openSession();     
       session.beginTransaction();
       //删除
       Student stu = new Student();
       stu = (Student)session.get(Student.class, 13);
       session.delete(stu);
       session.getTransaction().commit();
       session.close();
       sf.close();
       
	}
}
*/