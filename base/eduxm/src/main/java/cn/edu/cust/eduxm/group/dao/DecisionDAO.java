package cn.edu.cust.eduxm.group.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import cn.edu.cust.eduxm.group.domain.Decision;
import cn.edu.cust.util.db.DAOTemplate2;

public class DecisionDAO extends DAOTemplate2<Decision> {
	
	public DecisionDAO() {
		// "select count(*) from c_project where c_xmlb=? and c_yjlx=?";    //总数量
		//passSQL = "select count(*) from c_project where where c_xmlb=? and c_yjlx=? and c_psfs>=?";                //通过数量
	}

	@Override
	protected Decision wrapResult(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void setIdBeforeInsert(Decision t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Object[] getInsertParamValues(Decision t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object[] getUpdateParamValues(Decision t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public float passrate(List<Object> params,float psfs){
		String sql1 = "select count(*) from c_project where c_xmlb=? and c_yjlx=?";    //总数量
		String passSQL = "select count(*) from c_project where c_xmlb=? and c_yjlx=? and c_psfs>=?";                //通过数量
		int all = jt.queryForInt(sql1,params);
		params.add(psfs);
		int pass = jt.queryForInt(passSQL,params);
		return pass/all;
	}

}
