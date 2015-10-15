package dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * A data access object (DAO) providing persistence and search support for
 * Student entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see dao.Student
 * @author MyEclipse Persistence Tools
 */

public class StudentDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(StudentDAO.class);
	// property constants
	public static final String USERNAME = "username";
	public static final String PASSWORD = "password";
	public static final String AGE = "age";
	public static final String ADDRESS = "address";

	public boolean save(Student transientInstance) {
		log.debug("saving Student instance");
		boolean f = false;
		try {
			getSession().save(transientInstance);
			getTransaction().commit();
			f = true;
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			f = false;
			throw re;
		}
		return f;
	}

	public boolean delete(Student persistentInstance) {
		log.debug("deleting Student instance");
		boolean f = false;
		try {
			getSession().delete(persistentInstance);
		 	getTransaction().commit();
			f = true;
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			f = false;
			throw re;
		}
		return f;
	}

	public Student findById(java.lang.Integer id) {
		log.debug("getting Student instance with id: " + id);
		try {
			Student instance = (Student) getSession().get("dao.Student", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Student instance) {
		log.debug("finding Student instance by example");
		try {
			List results = getSession().createCriteria("dao.Student").add(
					Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Student instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Student as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUsername(Object username) {
		return findByProperty(USERNAME, username);
	}

	public List findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List findByAge(Object age) {
		return findByProperty(AGE, age);
	}

	public List findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	public List findAll() {
		log.debug("finding all Student instances");
		try {
			String queryString = "from Student";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/**
	 * 得到学生总数
	 * @return 学生记录总数
	 */
	public int getStudentTotalCount(String data,String username,String order) {
		Query q = getSession().createQuery("select count(*) from Student s where s."+data+" like '%"+username+"%'  order by s.id "+order+"");
		List cc = q.list();
		Integer a = (Integer) cc.get(0);
		return a.intValue();
	}
	/**
	 * 分页显示学生数据.
	 * @param currentPage
	 *            当前页码, 从 1 开始
	 * @param pageSize
	 *            每页显示数据量
	 * @return 用户数据
	 */
	public List findPagedAll(int currentPage, int pageSize,String data , String username,String order) {
		try {
			if (currentPage == 0) {
				currentPage = 1;
			}
			String queryString = "from Student s where s."+data+" like '%"+username+"%'  order by s.id "+order+"";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setFirstResult((currentPage - 1) * pageSize);
			queryObject.setMaxResults(pageSize);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}
	/**
	 * 获取总页面数.
	 * @param pageSize-每一页显示数据量
	 * @return 页面总数
	 */
	public int getTotalPage(int pageSize,String data,String username,String order) {
		dao.StudentDAO sDao = new dao.StudentDAO();
		int totalCount = sDao.getStudentTotalCount( data, username, order);
		// 得到页面总数
		int totalPageCount = ((totalCount + pageSize) - 1) / pageSize;
		return totalPageCount;
	}
	
}