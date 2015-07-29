/**
 * 
 */
package com.b510.hibernate.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.b510.hibernate.bean.Student;
import com.b510.hibernate.utils.EntityManagerUtil;

/**
 * 测试类
 * @author hongten<br>
 * @date 2013-3-25
 */
public class StudentTest {
	
	public static void main(String[] args) {
		//studentAdd();
		studentList();
		//studentFindById(new Integer(1));
		//studentMerge();
	}
	
	/**
	 * 添加一条记录
	 */
	public static void studentAdd(){
		EntityManager entityManager = EntityManagerUtil.getEntityManagerInstance();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Student student = new Student();
		student.setName("Tom Jhone");
		student.setAge(21);
		student.setSex("女");
		student.setNo("2009081513");
		
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
		entityManager.close();
	}
	
	/**
	 * 查询所有的记录
	 */
	@SuppressWarnings("unchecked")
	public static void studentList(){
		EntityManager entityManager = EntityManagerUtil.getEntityManagerInstance();
		List<Student> students = entityManager.createQuery("from Student").getResultList();
		
		for(Student student : students){
			System.out.println("学号："+student.getNo()+"  姓名："+student.getName()+"  性别："+student.getSex()+"  年龄："+student.getAge());
		}
		
		entityManager.close();
	}
	
	/**
	 * 根据id查询出相应记录
	 */
	public static void studentFindById(Integer id){
		EntityManager entityManager = EntityManagerUtil.getEntityManagerInstance();
		Student student = entityManager.find(Student.class, id);
		if(student != null){
			System.out.println("学号："+student.getNo()+"  姓名："+student.getName()+"  性别："+student.getSex()+"  年龄："+student.getAge());
		}
		
		entityManager.close();
	}
	
	/**
	 * 更新数据
	 */
	public static void studentMerge(){
		EntityManager entityManager = EntityManagerUtil.getEntityManagerInstance();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Integer id = 2;
		Student student = entityManager.find(Student.class, id);
		
		if(student != null){
			System.out.println("更新前....");
			System.out.println("学号："+student.getNo()+"  姓名："+student.getName()+"  性别："+student.getSex()+"  年龄："+student.getAge());
			student.setName("Hanyuan");
			entityManager.merge(student);
			entityTransaction.commit();
		}
		System.out.println("更新后....");
		studentFindById(id);
		entityManager.close();
	}
	
}
