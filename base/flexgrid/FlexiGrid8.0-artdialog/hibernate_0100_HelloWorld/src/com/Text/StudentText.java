package com.Text;
import com.hibernate.vo.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.Session;

public class StudentText {
	public static void main(String[] args) {
       Student s = new Student();
       s.setId(999);
       s.setName("dashen");
       s.setAge(123);
       
       //����hiberante�Ĳ���
       //System.out.println("wwweee"); 
		/*
		 * Configuration�� hibernate����ڣ� ���½�һ��Configuration��ʵ����ʱ��
		 * ������һ�µ�SettingsFactory�� ����ڹ�������д���һ��SettingsFactory
		 * ��Ὣ�����SettingsFactory����Hibernate��SettingsFactory ��ִ��reset()������
		 */
       Configuration cfg = new Configuration();
       //System.out.println("www");
		/*
		 * configure()����Ĭ�ϻ���classpath����Ѱ��hibernate.cfg.xml�ļ������û���ҵ����ļ���
		 * ϵͳ���ӡ������Ϣ���׳�HibernateException�쳣
		 * hibernate.cfg.xml not found
		 */

       SessionFactory sf = cfg.configure().buildSessionFactory();//����connection�Ĺ���
       //System.out.println("tttt");
       Session session = sf.openSession();//session�����ݿ��һ��connection
       
       session.beginTransaction();//hibernate�������ݿ�Ĳ�����һ������,ͬʱ����
       session.save(s);
       session.getTransaction().commit();//�ύ�����ݿ�
       session.close();
       sf.close();
       //System.out.println("wwwrrr");
	}
}
