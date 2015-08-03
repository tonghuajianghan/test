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
       
       //关于hiberante的操作
       //System.out.println("wwweee"); 
		/*
		 * Configuration是 hibernate的入口， 在新建一个Configuration的实例的时候，
		 * 会生成一新的SettingsFactory， 如果在构造参数中传入一个SettingsFactory
		 * 则会将传入的SettingsFactory赋给Hibernate的SettingsFactory 并执行reset()方法。
		 */
       Configuration cfg = new Configuration();
       //System.out.println("www");
		/*
		 * configure()方法默认会在classpath下面寻找hibernate.cfg.xml文件，如果没有找到该文件，
		 * 系统会打印如下信息并抛出HibernateException异常
		 * hibernate.cfg.xml not found
		 */

       SessionFactory sf = cfg.configure().buildSessionFactory();//产生connection的工厂
       //System.out.println("tttt");
       Session session = sf.openSession();//session是数据库的一个connection
       
       session.beginTransaction();//hibernate关于数据库的操作的一个事物,同时操作
       session.save(s);
       session.getTransaction().commit();//提交给数据库
       session.close();
       sf.close();
       //System.out.println("wwwrrr");
	}
}
