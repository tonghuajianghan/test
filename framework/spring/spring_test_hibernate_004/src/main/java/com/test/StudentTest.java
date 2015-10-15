package com.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.Test;

import vo.Student;

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

		// 已过一番查找后发现在<mapping class="">使用了Annotation ;
		// 而解析hibetnate的时候还是使用的解析xml的方式,

		AnnotationConfiguration configuration = new AnnotationConfiguration();
		configuration.configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(s);
		session.getTransaction().commit();
		session.close();

	}

	@Test
	public void test2() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("itcast");
		EntityManager em = factory.createEntityManager();
		Query query = em
				.createQuery("select stu from Student stu where stu.id = 1");
		Student stu = (Student) query.getSingleResult();
		System.out.println("stu.id:" + stu.getId());
		em.close();
		factory.close();
	}

}
