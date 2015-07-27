package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateSessionFactory;
import vo.Author;
import dao.inter.AuthorDao;

public class AuthorDBDao implements AuthorDao {

	public Session getSession() {
		// TODO Auto-generated method stub
		Session se=HibernateSessionFactory.getSession();
		return se;
	}

	public Session saveAuthor(Author author) {
		// TODO Auto-generated method stub
		Session session=getSession();
		Transaction tra=session.beginTransaction();
		session.save(author);
		tra.commit();
		return null;
	}

	public List<Author> queryAuthorByProperty(String propertyName, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteAuthorByID(String id) {
		// TODO Auto-generated method stub
		return false;
	}
}
