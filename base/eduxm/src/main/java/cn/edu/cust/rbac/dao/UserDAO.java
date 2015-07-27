package cn.edu.cust.rbac.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.cust.eduxm.expert.domain.Expert;
import cn.edu.cust.rbac.domain.User;
import cn.edu.cust.util.db.DAOTemplate2;

public class UserDAO extends DAOTemplate2<User> {
	
	public UserDAO(){
		insertSQL = "insert into c_user values (?,?,?,?)";
		loadSQL="select * from c_user where c_username = ?";
		updateSQL = "update c_user set c_username=?,c_password=?,c_roles=?,c_orgcode=? where c_username=?" ;
		getAllSQL = "select * from c_user";
		deleteSQL = "delete from c_user where c_username = ? ";
	}
	
	@Override
	protected User wrapResult(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		User u = new User();
		u.setFields(rs);
		return u;
	}

	@Override
	protected void setIdBeforeInsert(User t) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	protected Object[] getInsertParamValues(User t) {
		// TODO Auto-generated method stub
		return new Object[]{
				t.getUsername(),
				t.getPassword(),
				t.getRoles(),
				t.getOrgcode(),
		};
	}

	@Override
	protected Object[] getUpdateParamValues(User t) {
		// TODO Auto-generated method stub
		return new Object[]{
				t.getUsername(),
				t.getPassword(),
				t.getRoles(),
				t.getOrgcode(),
				t.getUsername()
		};
	}

}
