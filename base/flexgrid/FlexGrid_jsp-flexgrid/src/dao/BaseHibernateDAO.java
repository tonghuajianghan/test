package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateSessionFactory;


/**
 * Data access object (DAO) for domain model
 * @author MyEclipse Persistence Tools
 */
public class BaseHibernateDAO implements IBaseHibernateDAO {
	
	public Session getSession() {
		return HibernateSessionFactory.getSession();
	}
	public Transaction getTransaction() {
		return getSession().beginTransaction();
	}
}