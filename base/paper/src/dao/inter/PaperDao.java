package dao.inter;

import java.util.List;

import org.hibernate.Session;

import vo.Paper;

public interface PaperDao {

	public abstract Session getSession();

	public abstract void savePaper(Paper paper);

	/**
	 * ����ĳ�����Բ�ѯĳһ���̶�ֵ
	 */
	public abstract List<Paper> queryPaperByProperty(String propertyName,
			Object value);

	public abstract void deletePaperByID(String id);

	public abstract List<Paper> queryPaperByHql(String hql);

	public abstract List<Paper> queryPaperByPage(int pageNum);

	public abstract void updatePaper(Paper paper);

}