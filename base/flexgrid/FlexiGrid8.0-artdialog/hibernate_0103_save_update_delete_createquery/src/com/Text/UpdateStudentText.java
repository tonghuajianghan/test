//hibernate�ṩ��update����ʹ��
//�Զ�����и��Ĳ���
//update����������ʱ�����ڴ���ɾ޴���˷ѣ�Ŀǰû��̫�õĴ�����
//ʹ��jdbc�������������С�ڴ��ʹ����

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
       s.setName("����");
       s.setAge(23);
              
       Configuration cfg = new Configuration();     
       SessionFactory sf = cfg.configure().buildSessionFactory();      
       Session session = sf.openSession();     
       session.beginTransaction();
       //����
       Student stu = new Student();
       stu = (Student)session.get(Student.class, 1);
       stu.setName("jianghan");
       session.update(stu);
       //��������
       //��jdbc��hibernate�ֶ�����
       Student stu = new Student();
       System.out.print(stu.getName());
       try{
		   Connection conn = session.connection();
	     PreparedStatement stmt = conn.prepareStatement("update student  set age=age+100 where age>1 ");
		   //�ַ�������
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
