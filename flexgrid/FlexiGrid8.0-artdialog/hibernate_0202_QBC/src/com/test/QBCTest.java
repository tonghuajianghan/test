

package com.test;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import com.hibernate.vo.Student;

public class QBCTest {
  public static void main(String[] args) {
	 Configuration cfg = new Configuration();
	 SessionFactory sf = cfg.configure().buildSessionFactory();
	 Session session = sf.openSession();
	 session.beginTransaction();
	 
	 //查询年龄大于100的名字与年龄
	 
	 //创建标准查询类
     Criteria criteria = session.createCriteria(Student.class);
     //Restrictions是限定类
     //Restrictions.gt()方法表示greatthan，也就是大于的情况
     System.out.println("mark1");
     criteria.add(Restrictions.gt("age",new Integer(20)));
     System.out.println("mark2");
     List<Student> list = criteria.list();
     for(int i = 0;i < list.size();i++){
    	 Student stu =(Student)list.get(i);
    	 System.out.println(i);
    	 System.out.println(stu.getAge());
    	 System.out.println(stu.getName());
     }
     
     //查询年龄在20~30之间的所有学生对象
     
/*     List<Student> list2 = criteria.add(Restrictions.between("age", 40,130)).list();
     for(int i = 0;i < list2.size();i++){
    	 Student stu =(Student)list2.get(i);
    	 System.out.println(i);
    	 System.out.println(stu.getAge());
    	 System.out.println(stu.getName());
     }*/
     
     
     //查询student开头有h的所有对象
     //上一个list对下一个list有影响<未解决>，可能是限制了student
     
     List<Student> list3 = criteria.add(Restrictions.like("name", "h%")).list();
     for(int i = 0;i < list3.size();i++){
    	 Student stu =(Student)list3.get(i);
    	 System.out.println(i);
    	 System.out.println(stu.getAge());
    	 System.out.println(stu.getName());
     }
     
     
     
	 session.getTransaction().commit();
	 session.close();
	 sf.close();
	 
  }
}
