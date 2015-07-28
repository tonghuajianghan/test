package dao.inter;

import java.util.List;

import org.hibernate.Session;

import vo.Paper;

public interface PaperDao {

	public abstract Session getSession();

	public abstract void savePaper(Paper paper);

	/**
	 * 按照某个属性查询某一个固定值
	 */
	public abstract List<Paper> queryPaperByProperty(String propertyName,
			Object value);

	public abstract void deletePaperByID(String id);

	public abstract List<Paper> queryPaperByHql(String hql);

	public abstract List<Paper> queryPaperByPage(int pageNum);

	public abstract void updatePaper(Paper paper);

}