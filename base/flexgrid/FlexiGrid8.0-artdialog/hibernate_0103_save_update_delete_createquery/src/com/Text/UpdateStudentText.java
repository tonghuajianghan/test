//hibernate提供的update方法使用
//对对象进行更改操作
//update方法批处理时，对内存造成巨大的浪费，目前没有太好的处理方法
//使用jdbc方法处理可以缩小内存的使用率

package com.Text;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.hibernate.vo.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.Session;

public class UpdateStudentText {
	public static void main(String[] args) {
       Student s = new Student();
       s.setId(666666);
       s.setName("喊喊");
       s.setAge(23);
              
       Configuration cfg = new Configuration();     
       SessionFactory sf = cfg.configure().buildSessionFactory();      
       Session session = sf.openSession();     
       session.beginTransaction();
       //更新
       Student stu = new Student();
       stu = (Student)session.get(Student.class, 1);
       stu.setName("jianghan");
       session.update(stu);
       //批量更新
       //将jdbc与hibernate手动整合
       Student stu = new Student();
       System.out.print(stu.getName());
       try{
		   Connection conn = session.connection();
	     PreparedStatement stmt = conn.prepareStatement("update student  set age=age+100 where age>1 ");
		   //字符串连接
	      // PreparedStatement stmt = conn.prepareStatement("update student s  set s.name=concat(s.name,'beijing')");
	       
	       stmt.executeUpdate();
       }catch(SQLException e){
			e.printStackTrace();
		}
       session.getTransaction().commit();
       session.close();
       sf.close();
       
	}
}
