package cn.edu.cust.eduxm.group.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.cust.eduxm.group.domain.Score;
import cn.edu.cust.util.db.DAOTemplate2;

public class ScoreDAO extends DAOTemplate2<Score>{
	
	public ScoreDAO() {
		insertSQL = "insert into c_project_score values (?,?,?,?,?,?,?)";
		updateSQL = "update c_project_score set c_fs1=?, c_fs2=? ,c_fs3=? ,c_fs4=?,c_zf=? where c_xm_id=? and c_zj_id=?" ;
	}
	@Override
	protected Score wrapResult(ResultSet rs) throws SQLException {
		Score score = new Score();
		score.setFields(rs);
		return score;
	}

	@Override
	protected void setIdBeforeInsert(Score t) {
	}

	@Override
	protected Object[] getInsertParamValues(Score t) {
		return new Object[]{
				t.getXm_id(),
				t.getZjid(),
				t.getFs1(),
				t.getFs2(),
				t.getFs3(),
				t.getFs4(),
				t.getZf()
		};
	}

	@Override
	protected Object[] getUpdateParamValues(Score t) {
		return new Object[]{
				t.getFs1(),
				t.getFs2(),
				t.getFs3(),
				t.getFs4(),
				t.getZf(),
				t.getXm_id(),
				t.getZjid()
		};
	}
	
	
	//判断专家是第一次打分还是第二次
	public boolean judge(int xmid,String zjid){
		String judgeSQL = "select count(*) from c_project_score where c_xm_id="+xmid+" and c_zj_id='"+zjid+"'";
		if(jt.queryForInt(judgeSQL)==1){
			return true;
		}else{
			return false;
		}
	}
	
	//获得某个项目的专家打分的平均分
	public float getAvgScore(int xmid){
		String avgScoSQL = "select avg(c_zf) from c_project_score where c_xm_id="+xmid;
		return jt.queryForObject(avgScoSQL, Float.class);
	}
	
}
