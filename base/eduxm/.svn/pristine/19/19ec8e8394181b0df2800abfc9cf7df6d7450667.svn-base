package cn.edu.cust.eduxm.group.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;

import cn.edu.cust.eduxm.group.domain.AssignExpert;
import cn.edu.cust.util.db.DAOTemplate2;
import cn.edu.cust.util.db.JdbcTool;

public class AssignExpertDAO extends DAOTemplate2<AssignExpert> {
	
	public AssignExpertDAO(){
		insertSQL = "insert into c_group_expert values (?,?,?)";
		loadSQL="select * from c_group_expert where C_ZJZ_ID = ?";
		updateSQL = "update c_group_expert set C_ZJFZ_ID=?,C_ZJ_ID=?,C_ZJZ_ID=? where C_ZJFZ_ID=?" ;
		getAllSQL = "select * from c_group_expert";
		deleteSQL = "delete from c_group_expert where C_ZJ_ID = ? and C_ZJZ_ID = ? ";
	}

	@Override
	protected AssignExpert wrapResult(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		AssignExpert assignExpert = new AssignExpert();
		assignExpert.setFields(rs);
		return assignExpert;
	}

	@Override
	protected void setIdBeforeInsert(AssignExpert t) {
		// TODO Auto-generated method stub
		String getIdSQL = "select group_expert_sque.nextval from dual";
		t.setId(jt.queryForInt(getIdSQL));
	}

	@Override
	protected Object[] getInsertParamValues(AssignExpert t) {
		setIdBeforeInsert(t);
		return new Object[]{
				t.getId(),
				t.getExpertId(),
				t.getTeamId()
		};
	}

	@Override
	protected Object[] getUpdateParamValues(AssignExpert t) {
		return new Object[]{
				t.getExpertId(),
				t.getTeamId(),
				t.getId()
		};
	}
	/**
	 *修改分组人数
	 * @param groupId
	 */
	public void addGroupManCount(int groupId){
		
		JdbcTool.getJdbcTemplate().update("update c_group set c_rs = c_rs + 1 where c_zjz_id="+groupId);
		
	}
	
	/**
	 * 修改分组项目数
	 * @param groupId
	 */
	public void delGroupProjectCount(int groupId){
		
		JdbcTool.getJdbcTemplate().update("update c_group set c_rs = c_rs - 1 where c_zjz_id="+groupId);
		
	}
}
