package cn.edu.cust.eduxm.group.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.cust.eduxm.group.domain.Group;
import cn.edu.cust.util.db.DAOTemplate2;

public class GroupDAO extends DAOTemplate2<Group> {
	
	public GroupDAO(){
		insertSQL = "insert into c_group values (?,?,?,?,?,?,?,?,?,0,0)";
		loadSQL="select * from c_group where C_ZJZ_ID = ?";
		updateSQL = "update c_group set C_ZJZMC=?,C_ZYLY=?,C_ND=?, C_ZZ=? ,C_ZJZSM=? ,C_BZ=? ,C_ZDRS=? ,C_ZDXMS=? where C_ZJZ_ID=?" ;
		getAllSQL = "select * from c_group";
		deleteSQL = "delete from c_group where C_ZJZ_ID = ? ";
	}

	@Override
	protected Group wrapResult(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		Group group = new Group();
		group.setFields(rs);
		return group;
	}

	@Override
	protected void setIdBeforeInsert(Group t) {
		// TODO Auto-generated method stub
		String getIdSQL = "select group_sque.nextval from dual";
		t.setId(jt.queryForInt(getIdSQL));
	}

	@Override
	protected Object[] getInsertParamValues(Group t) {
		setIdBeforeInsert(t);
		return new Object[]{
				t.getId(),
				t.getGroupName(),
				t.getGroupField(),
				t.getYear(),
				t.getHeadman(),
				t.getGroupExplain(),
				t.getRemark(),
				t.getMaxManCount(),
				t.getMaxProjectCount()
		};
	}

	@Override
	protected Object[] getUpdateParamValues(Group t) {
		return new Object[]{
				t.getGroupName(),
				t.getGroupField(),
				t.getYear(),
				t.getHeadman(),
				t.getGroupExplain(),
				t.getRemark(),
				t.getMaxManCount(),
				t.getMaxProjectCount(),
				t.getId()
		};
	}

}
