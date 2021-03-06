package cn.edu.cust.eduxm.project.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import cn.edu.cust.eduxm.project.domain.AchievementBefore;
import cn.edu.cust.eduxm.project.domain.Member;
import cn.edu.cust.util.db.DAOTemplate2;
/**
 * 负责人和成员近期的研究成果DAO类
 * @author 王鹏程 2014-5-2
 *
 */
public class AchievementBeforeDAO extends DAOTemplate2<AchievementBefore>{
		String insertSQL = "insert into c_achievement_before values (?,?,?,?,?,?,?,?,?)";
		String loadSQL = "select * from c_achievement_before where c_cg_id = ?";
		String updateSQL = "update c_achievement_before set c_xm_id=?, c_cgmc=?,c_cgzz=?, c_cgxs=? ,c_fbkw=? ,c_fbsj=? ,c_bz1=? ,c_bz2=? where c_cg_id=?";
		String	getAllSQL = "select * from c_achievement_before";
		String	deleteSQL = "delete from c_achievement_before where c_cg_id = ? ";

	protected Object[] getInsertParamValues(AchievementBefore t) {
		return new Object[]{
				t.getId(),//自增长序列
				t.getXmid(),
				t.getCgmc(),
				t.getCgzz(),
				t.getCgxs(),
				t.getFbkw(),
				t.getFbsj(),
				t.getBz1(),
				t.getBz2()
		};
	}
	public void insert(AchievementBefore t) {
		setIdBeforeInsert(t);
		jt.update(insertSQL, getInsertParamValues(t));
	}
	protected AchievementBefore wrapResult(ResultSet rs) throws SQLException {
		AchievementBefore achievementBefore = new AchievementBefore();
		achievementBefore.setFields(rs);
		return achievementBefore;
	}

	protected void setIdBeforeInsert(AchievementBefore t) {
		String getIdSQL = "select ACHIEVEMENT_BEFORE_SQUE.nextval from dual";
		t.setId(jt.queryForInt(getIdSQL));
		
	}
	
	protected Object[] getUpdateParamValues(AchievementBefore t) {
		return new Object[]{
				t.getXmid(),
				t.getCgmc(),
				t.getCgzz(),
				t.getCgxs(),
				t.getFbkw(),
				t.getFbsj(),
				t.getBz1(),
				t.getBz2()
		};
	}

	/**
	 * 
	 * @param xm_id 对应项目的id
	 * @return
	 */
	public ArrayList<AchievementBefore> getAll(int xm_id) {
		System.out.println(xm_id+"----项目的id");
		String sql = "select *from c_achievement_before where c_xm_id = ?";
		System.out.println("1---看下有没有报错");
		return jt.query(sql,new Object[]{xm_id}, new ResultSetExtractor<ArrayList<AchievementBefore>>(){

			public ArrayList<AchievementBefore> extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				// TODO Auto-generated method stub
				System.out.println("2---看下有没有报错");
				ArrayList<AchievementBefore> result = new ArrayList<AchievementBefore>();
				while(rs.next())
					result.add(wrapResult(rs));
				
				System.out.println("3---看下有没有报错");
				return result;
			}

		});
	}

}
