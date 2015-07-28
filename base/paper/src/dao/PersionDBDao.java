package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.inter.PersionDao;

import util.HibernateSessionFactory;
import vo.Person;

public class PersionDBDao implements PersionDao{
	public  Session getSession(){
		Session se=HibernateSessionFactory.getSession();
		return se;
	}

	public  Session savePersion(Person persion){
		Session session=getSession();
		Transaction tra=session.beginTransaction();
		session.save(persion);
		tra.commit();
		session.close();
		return null;
	}

	public  List<Person> queryPersionById(int id){
		Session session = getSession();
		Transaction tra = session.beginTransaction();
		Query query = session.createQuery("from Persion where id='"+id+"'");
		tra.commit();
		session.close();
		return query.list();
	}

	public  boolean deletePersionById(int id){
		Session session = getSession();
		Transaction tra = session.beginTransaction();
		Person persion = new Person();
		persion = (Person)session.get(Person.class, id);
		session.delete(persion);
		session.getTransaction().commit();
		tra.commit();
		session.close();
		return true;		
	}

	public boolean insertPersionById() {
		// TODO Auto-generated method stub
		return false;
	}

}
