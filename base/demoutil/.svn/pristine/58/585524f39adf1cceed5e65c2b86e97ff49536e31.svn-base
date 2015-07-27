package cn.edu.cust.demo.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.cust.util.db.DAOTemplate2;

public class AccountDAO extends DAOTemplate2<Account>{
	/**
	 * 在构造函数中定义好sql语句
	 */
	public AccountDAO(){
		loadSQL = "select * from c_account where c_id = ?";
		updateSQL = "update c_account set c_balance = ? where c_id = ?";
	}
	
	@Override
	protected Object[] getInsertParamValues(Account arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object[] getUpdateParamValues(Account acc) {
		// TODO Auto-generated method stub
		return new Object[]{acc.getBalance(), acc.getId()};
	}

	@Override
	protected void setIdBeforeInsert(Account arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Account wrapResult(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		Account acc = new Account();
		acc.setId(rs.getString("c_id"));
		acc.setPass(rs.getString("c_pass"));
		acc.setBalance(rs.getFloat("c_balance"));
		return acc;
	}
}
