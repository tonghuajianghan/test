

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
	 
	 //��ѯ�������100������������
	 
	 //������׼��ѯ��
     Criteria criteria = session.createCriteria(Student.class);
     //Restrictions���޶���
     //Restrictions.gt()������ʾgreatthan��Ҳ���Ǵ��ڵ����
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
     
     //��ѯ������20~30֮�������ѧ������
     
/*     List<Student> list2 = criteria.add(Restrictions.between("age", 40,130)).list();
     for(int i = 0;i < list2.size();i++){
    	 Student stu =(Student)list2.get(i);
    	 System.out.println(i);
    	 System.out.println(stu.getAge());
    	 System.out.println(stu.getName());
     }*/
     
     
     //��ѯstudent��ͷ��h�����ж���
     //��һ��list����һ��list��Ӱ��<δ���>��������������student
     
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
