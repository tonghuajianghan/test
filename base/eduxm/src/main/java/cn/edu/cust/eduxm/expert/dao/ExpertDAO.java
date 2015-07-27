package cn.edu.cust.eduxm.expert.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.PreparedStatementSetter;

import cn.edu.cust.eduxm.expert.domain.Expert;
import cn.edu.cust.util.db.DAOTemplate2;
import cn.edu.cust.util.db.JdbcTool;



public class ExpertDAO extends DAOTemplate2<Expert> {
	
	
	
	public ExpertDAO(){
		insertSQL = "insert into c_expert(C_USERNAME,C_XM,C_XB,C_ZC,C_ZW,C_ZYLY,C_YJFX,C_CSNY,C_SSDW,C_DZYJ,C_LXDH,C_ZPLJ,C_ZT,C_ZJJJ,C_BZ) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		loadSQL="select * from c_expert where C_USERNAME = ?";
		updateSQL = "update c_expert set C_XM=?,C_XB=?, C_ZC=? ,C_ZW=? ,C_ZYLY=? ,C_YJFX=?,C_CSNY=?,C_SSDW=?,C_DZYJ=?,C_LXDH=?,C_ZPLJ=?,C_ZT=?,C_ZJJJ=?,C_BZ=?where C_USERNAME=?" ;
		getAllSQL = "select * from c_expert";
		deleteSQL = "delete from c_expert where C_USERNAME = ? ";
	}
	@Override
	protected Expert wrapResult(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		Expert t = new Expert();
		t.setFields(rs);
		return t;
	}

	@Override
	protected void setIdBeforeInsert(Expert t) {
		// TODO Auto-generated method stub
	}

	@Override
	protected Object[] getInsertParamValues(Expert t) {
		// TODO Auto-generated method stub
		t.setZt("0");
		return new Object[]{
				t.getUsername(),
				t.getXm(),
				t.getXb(),
				t.getZc(),
				t.getZw(),
				t.getZyly(),
				t.getYjfx(),
				t.getCsny(),
				t.getSsdw(),
				t.getDzyj(),
				t.getLxdh(),
				t.getZplj(),
				t.getZt(),
				t.getZjjj(),
				t.getBz(),
		};
	}

	@Override
	protected Object[] getUpdateParamValues(Expert t) {
		// TODO Auto-generated method stub
		return new Object[]{
				
				t.getXm(),
				t.getXb(),
				t.getZc(),
				t.getZw(),
				t.getZyly(),
				t.getYjfx(),
				t.getCsny(),
				t.getSsdw(),
				t.getDzyj(),
				t.getLxdh(),
				t.getZplj(),
				t.getZt(),
				t.getZjjj(),
				t.getBz(),
				t.getUsername(),
		};
	}
	
	public void changeZt(String username,String zt){
		String sql="update  c_expert set C_ZT=? where C_USERNAME=?";
		jt.update(sql,zt,username);
	}
	

	

}
