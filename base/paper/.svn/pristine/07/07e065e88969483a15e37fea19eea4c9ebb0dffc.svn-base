package dao.inter;

import java.util.List;

import org.hibernate.Session;

import vo.Author;

public interface AuthorDao {
	public Session getSession();
	public Session saveAuthor(Author author);
	public List<Author> queryAuthorByProperty(String propertyName,Object value);
	public boolean deleteAuthorByID(String id);

}
