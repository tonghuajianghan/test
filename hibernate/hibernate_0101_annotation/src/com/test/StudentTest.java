/*------------------------------------------------------------------------- 
 * ��Ȩ���У�
 * ���ߣ�����
 * ��ϵ��ʽ��jianghan@gyyx.cn 
 * ����ʱ�䣺2015-8-2 ����10:07:32 
 * �汾�ţ�v1.0 
 * ������Ҫ��;������ 
 * 
-------------------------------------------------------------------------*/
package com.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.hibernate.vo.Student;

public class StudentTest {

	/**
	 * @Title: test
	 * @Author: jianghan
	 * @Description: TODO
	 * 
	 */
	// @Test
	public void test() {
		// fail("Not yet implemented");
		Student s = new Student();
		// s.setId(9);
		s.setName("1111");
		s.setAge(100);
		Configuration cfg = new Configuration();
		@SuppressWarnings("deprecation")
		SessionFactory sf = cfg.configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(s);
		session.getTransaction().commit();
		session.close();
		sf.close();
	}

	@Test
	public void test2() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("itcast");
		EntityManager em = factory.createEntityManager();
		Query query = em
				.createQuery("select stu from Student stu where stu.id = 1");
		Student stu = (Student)query.getSingleResult();
		System.out.println("stu.id:" + stu.getId());
		em.close();
		factory.close();
	}

}