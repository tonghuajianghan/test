package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import util.HibernateSessionFactory;
import vo.Author;
import vo.Paper;
import vo.Person;
import dao.inter.PaperDao;

public class PaperDBDao implements PaperDao {

	private static int pageSize=20;
	/* (non-Javadoc)
	 * @see dao.PaperDao#getSession()
	 */
	public Session getSession() {
		// TODO Auto-generated method stub
		Session se=HibernateSessionFactory.getSession();
		return se;
	}

	/* (non-Javadoc)
	 * @see dao.PaperDao#savePaper(vo.Paper)
	 */
	public void savePaper(Paper paper) {
		// TODO Auto-generated method stub
		try{
			Session session=getSession();
			Transaction tra=session.beginTransaction();
			session.save(paper);
			tra.commit();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
/* (non-Javadoc)
 * @see dao.PaperDao#queryPaperByProperty(java.lang.String, java.lang.Object)
 */
	public List<Paper> queryPaperByProperty(String propertyName, Object value) {
		// TODO Auto-generated method stub
		Criteria criteria=getSession().createCriteria(Paper.class);
		Criterion criterion=Restrictions.eq(propertyName, value);
		criteria.add(criterion);
		List<Paper> list=criteria.list();
		return list;
	}

	/* (non-Javadoc)
	 * @see dao.PaperDao#deletePaperByID(java.lang.String)
	 */
	public void deletePaperByID(String id) {
		// TODO Auto-generated method stub
		Session session=getSession();
		session.delete(session.load(Paper.class, id));
	}

	/* (non-Javadoc)
	 * @see dao.PaperDao#queryPaperByHql(java.lang.String)
	 */
	public List<Paper> queryPaperByHql(String hql) {
		// TODO Auto-generated method stub
		
		return null;
	}

	/* (non-Javadoc)
	 * @see dao.PaperDao#queryPaperByPage(int)
	 */
	public List<Paper> queryPaperByPage(int pageNum) {
		// TODO Auto-generated method stub 
		        List<Paper> result = new ArrayList();     
		        Criteria criteria = getSession().createCriteria(Paper.class);    
		        criteria.setFirstResult(0);   
		        criteria.setMaxResults(10);   
		                //from为起始页数size为一页10条数据   
		              //获得10条记录的集合   
		        result = criteria.list();   
		        criteria.setFirstResult(0);   
		        criteria.setProjection(Projections.projectionList().add(   
		               Projections.rowCount()));   
		                //获得满足条件的总记录数   
		        int count = ((Integer) criteria.uniqueResult()).intValue();   
		        System.out.println("总数："+count);
		        return result;
	}

	/* (non-Javadoc)
	 * @see dao.PaperDao#updatePaper(vo.Paper)
	 */
	public void updatePaper(Paper paper) {
		// TODO Auto-generated method stub
		Session session=getSession();
		session.merge(paper);
	}

	public Session savePersion() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Person> queryPersionById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deletePersionById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean insertPersionById() {
		// TODO Auto-generated method stub
		return false;
	}

}
